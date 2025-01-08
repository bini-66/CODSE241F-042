/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmanagementsystem;

import GUI.loginPage;
import java.sql.Connection;

/**
 *
 * @author binit
 */
public class StudentManagementSystem {

    public static void main(String[] args) {
        loginPage lpg=new loginPage();
        lpg.setVisible(true);
        
        // Get the singleton instance
        DBcon db = DBcon.getInstance();

        // Retrieve the connection
        Connection con = db.getConnection();

    }
}
