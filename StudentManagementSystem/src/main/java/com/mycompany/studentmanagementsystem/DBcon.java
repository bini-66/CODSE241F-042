/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagementsystem;
import java.sql.*;
/**
 *
 * @author binit
 */
public class DBcon {
    private static DBcon instance; 
    private Connection connection;            

    private DBcon() {
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentManagementdb", "root", "Bini@2004");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("Database Driver not found: " + e.getMessage());
        }
    }

    // Method to get the singleton instance
    public static DBcon getInstance() {
        if (instance == null) {
            instance = new DBcon();
        }
        return instance;
    }

    // Method to get the database connection
    public Connection getConnection() {
        return connection;
    }
}
    

