module com.itech.desktopfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.itech.desktopfx to javafx.fxml;
    exports com.itech.desktopfx;
    exports com.itech.desktopfx.controllers;
    exports com.itech.desktopfx.controllers.auth;
}