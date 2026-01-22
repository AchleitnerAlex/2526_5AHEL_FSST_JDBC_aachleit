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
    protected ResultSet rs;

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
        String sql;
        Statement st = conn.createStatement();
        sql = "SELECT name, COUNT(c.name) " +
                "FROM country " +
                "JOIN city c " +
                "ON country.code = c.countrycode" +
                "GROUB BY name" +
                "ORDER BY COUNT(c.name) DESC ;";

        rs = st.executeQuery(sql);
    }

    public void changedAmouCountry(MouseEvent mouseEvent) {

    }

    protected void chartupdate(int amoOfCountry) throws SQLException {



        // TODO: SQL Abfrage einmal mit allen Daten in eine Collection
        //   bei chartUpdate Zugriff auf die Collection und entsprechend filtern





    }
}

