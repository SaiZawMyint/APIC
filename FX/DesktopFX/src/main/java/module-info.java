module com.itech.desktopfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.itech;
    requires java.prefs;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens com.itech.desktopfx to javafx.fxml, com.google.gson;
    opens com.itech.desktopfx.controllers.auth to javafx.fxml;
    opens com.itech.desktopfx.form to com.google.gson;

    exports com.itech.desktopfx;
    exports com.itech.desktopfx.controllers;
    exports com.itech.desktopfx.controllers.auth;
    exports com.itech.desktopfx.components.auth;
}