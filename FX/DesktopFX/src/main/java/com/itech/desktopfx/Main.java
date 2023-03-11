package com.itech.desktopfx;

import com.itech.desktopfx.persistences.preferences.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    private static Stage stage;
    @Override
    public void start(Stage stg) throws IOException {
        String fxml = handleAuthenticatedUser();
        stage = stg;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), 500, 350);
        stage.setTitle("DesktopFx");
        stage.setScene(scene);
        stage.show();
    }
    public static void changeScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxml)));
        stage.getScene().setRoot(root);
    }
    public static void main(String[] args) {
        launch();
    }
    private String handleAuthenticatedUser(){
        return new User().getToken() == null ? "views/auth/login-view.fxml" :"views/dashboard.fxml";
    }
}