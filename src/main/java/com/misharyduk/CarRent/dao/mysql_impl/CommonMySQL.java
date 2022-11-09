package com.misharyduk.CarRent.dao.mysql_impl;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class CommonMySQL {
    private Connection connection;

    protected CommonMySQL(){
        String url = "jdbc:mysql://localhost:3306/car_rent";
        String username = "root";
        String password = "MR!QAZ2wsx";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
