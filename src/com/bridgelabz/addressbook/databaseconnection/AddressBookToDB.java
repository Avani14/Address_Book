package com.bridgelabz.addressbook.databaseconnection;

import com.bridgelabz.addressbook.AddressBookService;
import com.bridgelabz.addressbook.Contacts;

import javax.xml.transform.Result;
import java.sql.*;

public class AddressBookToDB implements IAddressBookToDB {
    Connection connection = (new DBConnection()).getConnection() ;
    Statement statement;
    ResultSet resultSet;
    @Override
    public void getData() {
        String retrieveQuery = "select * from address_book;";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(retrieveQuery);
            while(resultSet.next()){
                System.out.println("Address Book Type: "+resultSet.getString("name"));
                System.out.println("Address Book first_name: "+resultSet.getString("first_name"));
                System.out.println("Address Book last_name: "+resultSet.getString("last_name"));
                System.out.println("Address Book address: "+resultSet.getString("address"));
                System.out.println("Address Book city: "+resultSet.getString("city"));
                System.out.println("Address Book state: "+resultSet.getString("state"));
                System.out.println("Address Book zip: "+resultSet.getInt("zip"));
                System.out.println("Address Book phone_number: "+resultSet.getLong("phone_number"));
                System.out.println("Address Book email: "+resultSet.getString("email"));
                System.out.println("----------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void getDataByTimeStamp(String start_time, String end_time) {
        String retrieveQuery = "select * from address_book where time_stamp between cast('"+start_time+"' as datetime) and cast('"+end_time+"' as datetime);";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(retrieveQuery);
            while(resultSet.next()){
                System.out.println("Address Book Type: "+resultSet.getString("name"));
                System.out.println("Address Book first_name: "+resultSet.getString("first_name"));
                System.out.println("Address Book last_name: "+resultSet.getString("last_name"));
                System.out.println("Address Book address: "+resultSet.getString("address"));
                System.out.println("Address Book city: "+resultSet.getString("city"));
                System.out.println("Address Book state: "+resultSet.getString("state"));
                System.out.println("Address Book zip: "+resultSet.getInt("zip"));
                System.out.println("Address Book phone_number: "+resultSet.getLong("phone_number"));
                System.out.println("Address Book email: "+resultSet.getString("email"));
                System.out.println("----------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateData(String field,String setField,String address_book, String first_name) {
        String updateQuery = "update address_book set "+field+" = '"+setField+"' where first_name = '"+first_name+"' and name = '"+address_book+"';";
        String retrieveQuery = "select * from address_book where first_name = '"+first_name+"' and name = '"+address_book+"';";
        try {
            statement = connection.createStatement();
            statement.execute(updateQuery);
            System.out.println("Updated Successfully");
            resultSet = statement.executeQuery(retrieveQuery);
            while(resultSet.next()){
                System.out.println("Address Book Type: "+resultSet.getString("name"));
                System.out.println("Address Book first_name: "+resultSet.getString("first_name"));
                System.out.println("Address Book last_name: "+resultSet.getString("last_name"));
                System.out.println("Address Book address: "+resultSet.getString("address"));
                System.out.println("Address Book city: "+resultSet.getString("city"));
                System.out.println("Address Book state: "+resultSet.getString("state"));
                System.out.println("Address Book zip: "+resultSet.getInt("zip"));
                System.out.println("Address Book phone_number: "+resultSet.getLong("phone_number"));
                System.out.println("Address Book email: "+resultSet.getString("email"));
                System.out.println("----------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getCountByCity(String columnName,String cityOrState) {
        String retrieveQuery = "select * from address_book where "+columnName+" = '"+cityOrState+"';";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(retrieveQuery);
            while(resultSet.next()){
                System.out.println("Address Book Type: "+resultSet.getString("name"));
                System.out.println("Address Book first_name: "+resultSet.getString("first_name"));
                System.out.println("Address Book last_name: "+resultSet.getString("last_name"));
                System.out.println("Address Book address: "+resultSet.getString("address"));
                System.out.println("Address Book city: "+resultSet.getString("city"));
                System.out.println("Address Book state: "+resultSet.getString("state"));
                System.out.println("Address Book zip: "+resultSet.getInt("zip"));
                System.out.println("Address Book phone_number: "+resultSet.getLong("phone_number"));
                System.out.println("Address Book email: "+resultSet.getString("email"));
                System.out.println("----------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insertData(String book_name, Contacts c) {
        String insertQuery = "insert into address_book(first_name ,last_name ,address,city,state,zip,phone_number,email,name) values(?,?,?,?,?,?,?,?,'"+book_name+"')";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1,c.getFirstName());
            preparedStatement.setString(2,c.getLastName());
            preparedStatement.setString(3,c.getAddress());
            preparedStatement.setString(4,c.getCity());
            preparedStatement.setString(5,c.getState());
            preparedStatement.setInt(6,c.getZip());
            preparedStatement.setLong(7,c.getPhone());
            preparedStatement.setString(8,c.getEmail());
            preparedStatement.executeUpdate();
            System.out.println("Inserted Successfully in Database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
