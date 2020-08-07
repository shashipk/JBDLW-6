package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Connector to connect java application to a database.
        //Application : Phone book.
        // You will pass name and phone number of your fried
        //Some software or translator we need to connect java code database.
        //mysql jdbc connector

        String name = "GeeksForGeeks";
        String phonenumber = "9876543210";

        Connection connection = null;
        Statement statement = null;

        String urlOfDatabase = "jdbc:mysql://localhost:3306/tutorial2";
        String user = "root";
        String password = "";
        Phonebook phonebook=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(urlOfDatabase,user,password);
            System.out.println("Connection Established");
            statement  = connection.createStatement();
            //String sql = "create database tutorial2";
//            String sql = " CREATE TABLE phonebook "+
//                    " (id bigint not null,"+
//                    " name varchar(255) not null,"+
//                    " number varchar(255) not null," +
//                    "primary key (id))";
//            String sql = "INSERT INTO phonebook (ID,NAME,NUMBER)" +
//                    "VALUES (2,'John','9876543211' )";
            String sql = "Select * from phonebook " +
                    "where name = 'john'";
            ResultSet resultSet = statement.executeQuery(sql);
            phonebook = new Phonebook();
            while(resultSet.next()){
                phonebook.name = resultSet.getString("name");
                phonebook.number = resultSet.getString("number");
; }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(phonebook.name);
    }
}
