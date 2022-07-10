package com.bridgelabz.addressbook.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    Connection connection;
    public Connection getConnection(){
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        final String userName = "root";
        final String password = "Avani@1234";
        final String baseURL = "jdbc:mysql://localhost:3306";
        final String database = "/address_book_service";
        final String finalURL = new StringBuffer(baseURL).append(database).toString();
        try{
            connection = DriverManager.getConnection(finalURL,userName,password);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
