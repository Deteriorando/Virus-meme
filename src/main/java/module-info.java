module dete.application.virus {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens dete.application.virus to javafx.fxml;
    exports dete.application.virus;
    exports dete.application.virus.controller;
    opens dete.application.virus.controller to javafx.fxml;
}