package com.itech.desktopfx.services.impls;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itech.api.tools.Response;
import com.itech.api.v1.tools.API;
import com.itech.desktopfx.Main;
import com.itech.desktopfx.components.auth.LoginComponent;
import com.itech.desktopfx.form.LoginForm;
import com.itech.desktopfx.persistences.preferences.User;
import com.itech.desktopfx.services.LoginService;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Map;

public class LoginServiceImpl implements LoginService {
    public static final String REALTIME_HOST = "http://150.95.82.104:8080/ems/api";
    @Override
    public Object login(LoginComponent component) {
        API api = new API();
        LoginForm form = new LoginForm();
        form.setLoginId(component.getLoginId().getText());
        form.setPassword(component.getPassword().getText());
        component.getLoginBtn().setDisable(true);
        component.getLoadingIcon().setVisible(true);
        api.post(REALTIME_HOST.concat("/showLogin"), form)
                .then(r->loginSuccess(r,component)).exception(e ->{
                    e.getException().printStackTrace();
                    return e;
                });
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            component.getLoadingIcon().setVisible(false);
            component.getLoginBtn().setDisable(false);
        }));
        timeline.play();
        return null;
    }

    private Response loginSuccess(Response response, LoginComponent component) {
        System.out.println(response);
        if(response.getCode()!=200){
            errors(component);
        }else{
            try {
                putUserData(response);
                Main.changeScene("views/dashboard.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return response;
    }
    private Response loginFailure(Response response, LoginComponent component){
        errors(component);
        return response;
    }
    private void errors(LoginComponent component){
        component.getLoginId().getStyleClass().add("error");
        component.getPassword().getStyleClass().add("error");
    }
    private void putUserData(Response response){
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> data = mapper.readValue((String) response.getData(), Map.class);
            User user = new User();
            user.setToken((String) data.get("token"));
            user.setEmployeeId((String) ((Map)data.get("userInfomation")).get("employeeId"));
            user.setEmployeeName((String) ((Map)data.get("userInfomation")).get("employeeName"));
            user.setEmployeeType((Integer) ((Map)data.get("userInfomation")).get("employeeType"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
