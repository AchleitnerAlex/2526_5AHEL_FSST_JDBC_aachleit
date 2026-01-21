package com.example.javafxanwendung;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.sql.*;
import java.util.Properties;

public class HelloController {
    @FXML
    private Label welcomeText;
    public HelloController() {
        String url = "jdbc:postgresql://xserv:5432/world2";
        Properties props = new Properties();
        props.setProperty("user", "reader");
        props.setProperty("password", "reader");
        try {
            Connection conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
