package com.itech.desktopfx.controllers.auth;

import com.itech.desktopfx.components.auth.LoginComponent;
import com.itech.desktopfx.services.LoginService;
import com.itech.desktopfx.services.impls.LoginServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private LoginComponent form;
    private LoginService loginService;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginService = new LoginServiceImpl();
        form.getLoginBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                login(event);
            }
        });
        form.getLoginId().textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.isEmpty()) {
                form.getLoginId().getStyleClass().add("error");
            }else{
                form.getLoginId().getStyleClass().remove("error");
            }
        });
        form.getPassword().textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.isEmpty()) {
                form.getPassword().getStyleClass().add("error");
            }else{
                form.getPassword().getStyleClass().remove("error");
            }
        });
    }
    private void login(ActionEvent event){
        event.consume();
        loginService.login(form);
    }
}
