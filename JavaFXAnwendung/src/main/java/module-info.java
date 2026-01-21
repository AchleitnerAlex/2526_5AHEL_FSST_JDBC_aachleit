module com.example.javafxanwendung {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafxanwendung to javafx.fxml;
    exports com.example.javafxanwendung;
}