package com.example.javafxanwendung;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.sql.*;
import java.util.Properties;

public class HelloController {

    public Slider sl_amountOfCountry;
    protected Connection conn;

    public BarChart bc_amountcity;

    public HelloController() {
        String url = "jdbc:postgresql://xserv:5432/world2";
        Properties props = new Properties();
        props.setProperty("user", "reader");
        props.setProperty("password", "reader");
        try {
            conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Initialize() throws SQLException {
        sl_amountOfCountry.adjustValue(1);


    }

    public void changedAmouCountry(MouseEvent mouseEvent) {

    }

    protected void chartupdate(int amoOfCountry) throws SQLException {
        Statement st = conn.createStatement();


    }
}

