package com.itech.desktopfx.components.auth;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginComponent extends AnchorPane {
    @FXML public TextField loginId;
    @FXML public PasswordField password;
    @FXML public Label loginIdError;
    @FXML public Label passwordError;
    @FXML public Button loginBtn;
    @FXML public ProgressIndicator loadingIcon;

    public LoginComponent() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextField getLoginId() {
        return loginId;
    }

    public void setLoginId(TextField loginId) {
        this.loginId = loginId;
    }

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public Label getLoginIdError() {
        return loginIdError;
    }

    public void setLoginIdError(Label loginIdError) {
        this.loginIdError = loginIdError;
    }

    public Label getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(Label passwordError) {
        this.passwordError = passwordError;
    }

    public Button getLoginBtn() {
        return loginBtn;
    }

    public void setLoginBtn(Button loginBtn) {
        this.loginBtn = loginBtn;
    }

    public ProgressIndicator getLoadingIcon() {
        return loadingIcon;
    }

    public void setLoadingIcon(ProgressIndicator loadingIcon) {
        this.loadingIcon = loadingIcon;
    }
}
