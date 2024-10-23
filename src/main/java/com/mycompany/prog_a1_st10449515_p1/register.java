/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog_a1_st10449515_p1;

/**
 *
 * @author Thandwa
 */


public class register {
    private String Username;  // Private field
    private String Password;  // Private field

    // Method to check if the Username is valid
    public boolean checkUsername(String Username) {
        // Username must contain an underscore and be at least 5 characters long
        return Username.contains("_") && Username.length() >= 5;
    }

    // Method to check if the Password is valid
    public boolean checkPassword(String Password) {
        boolean hasDigit = false;
        boolean hasCapital = false;
        boolean hasSpecial = false;
        boolean isLongEnough = Password.length() >= 8;
        
        String specialCharacters = "+=-_)(*&^%$#@!";

        // Check each character in the password for the required conditions
        for (int i = 0; i < Password.length(); i++) {
            char character = Password.charAt(i);
            if (Character.isDigit(character)) {
                hasDigit = true;
            }
            if (Character.isUpperCase(character)) {
                hasCapital = true;
            }
            if (specialCharacters.contains(String.valueOf(character))) {
                hasSpecial = true;
            }
        }

        return isLongEnough && hasDigit && hasCapital && hasSpecial;
    }

    // Method to register the user by setting the Username and Password
    public void registerUser(String username, String password) {
        this.Username = username;
        this.Password = password;
    }

    // Method to log in the user
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        // Check if the provided credentials match the stored Username and Password
        return enteredUsername.equals(this.Username) && enteredPassword.equals(this.Password);
    }

    // Method to return login success or failure message
    public String returnLoginStatus(boolean isSuccess, String firstName, String lastName) {
        if (isSuccess) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again!";
        } else {
            return "Username or password validation failed.";
        }
    }
}
