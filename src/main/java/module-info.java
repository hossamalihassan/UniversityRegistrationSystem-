module com.example.university_registration_system_gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
//    requires sqlite.jdbc;


    opens com.example.university_registration_system_gui to javafx.fxml;
    exports com.example.university_registration_system_gui;
}