/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagementsystem;

/**
 *
 * @author binit
 */
public class userSession {
       //singleton class to maintain user session
    private static userSession instance;
    private String userType;
    
    private userSession(){
        
    }
    
    public static userSession getInstance(){
        if (instance == null) {
        instance = new userSession(); // lazy initializatin
    }
        return instance;
    }
    public String getuUserType(){
        return userType;
    }
    public void setUserType(String userType){
        this.userType=userType;
    }
    
}
