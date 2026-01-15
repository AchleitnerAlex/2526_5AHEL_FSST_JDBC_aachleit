module com.example.javafxanwendung {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxanwendung to javafx.fxml;
    exports com.example.javafxanwendung;
}