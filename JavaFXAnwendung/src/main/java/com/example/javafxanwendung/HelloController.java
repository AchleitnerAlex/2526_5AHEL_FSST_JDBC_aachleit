package com.example.javafxanwendung;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Properties;

public class HelloController {

    public Slider sl_amountOfCountry;
    protected Connection conn;
    protected ResultSet rs;
    public LinkedHashMap<String, String> chartInput;

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

    public void initialize() throws SQLException {
        sl_amountOfCountry.adjustValue(1);
        String sql;
        Statement st = conn.createStatement();

        sql = "SELECT co.name AS CountryName, COUNT(c.name) AS amountOfCity " +
                "FROM country co " +
                "JOIN city c " +
                "ON co.code = c.countrycode " +
                "GROUP BY co.name " +
                "ORDER BY COUNT(c.name) DESC ;";
        rs = st.executeQuery(sql);

        chartInput = new LinkedHashMap<>();
        while (rs.next()) {
            chartInput.put(rs.getString("COUNTRYNAME"), rs.getString("amountofCity"));
        }

    }

    public void changedAmouCountry(MouseEvent mouseEvent) throws SQLException {
        int amountofCountry;
        amountofCountry = (int) sl_amountOfCountry.getValue();
        chartupdate(amountofCountry);
    }

    protected void chartupdate(int amoOfCountry) throws SQLException {




    }
}

