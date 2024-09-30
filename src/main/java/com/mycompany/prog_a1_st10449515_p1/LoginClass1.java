/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog_a1_st10449515_p1;

/**
 *
 * @author Thandwa
 */
public class LoginClass1 {
    private UserClass1 registerUser;
    
    // Initializing the object in the class
    public LoginClass1(UserClass1 user) {
        this.registerUser = user;
    }

   public String registerUser() {
    String result = "";
    
    // Check username validity
    if (registerUser.checkUserName()) {
        result += "Username successfully captured.";
    } else {
        result += "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than 5 characters in length.";
    }

    // Check password complexity
    if (registerUser.checkPasswordComplexity()) {
        result += "Password successfully captured.";
    } else {
        result += "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
    }

    return result;
}

    // Method to log the User into the system and check if the username and password are correct
    public boolean loginUser(String UserName, String Password) {
        return this.registerUser != null && registerUser.getUsername().equals(UserName) && registerUser.getPassword().equals(Password);
    }

    // Method to inform a user of their login status
   public String returnLoginStatus(boolean loginSuccessful) {
    if (loginSuccessful) {
        // Add a space between firstName and lastName
        return "Welcome " + registerUser.getFirstName() + " " + registerUser.getLastName() + ", it is great to see you again.";
    } else {
        return "Username or password incorrect, please try again.";
    }
 }
}
