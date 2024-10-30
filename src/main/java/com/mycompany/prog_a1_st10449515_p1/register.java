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
    private String username;  // Private field
    private String password;  // Private field

    // Method to check if the username is valid
    public boolean checkUserName(String username) {
        // Username must contain an underscore and be at least 5 characters long
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check if the password meets complexity requirements
    public boolean checkPasswordComplexity(String password) {
        boolean hasDigit = false;
        boolean hasCapital = false;
        boolean hasSpecial = false;
        boolean isLongEnough = password.length() >= 8;

        String specialCharacters = "+=-_)(*&^%$#@!";

        // Check each character in the password for the required conditions
        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
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

    // Method to register the user by setting the username and password
    public String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        } else {
            this.username = username;
            this.password = password;
            return "User successfully registered";
        }
    }

    // Method to log in the user
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        // Check if the provided credentials match the stored username and password
        return enteredUsername.equals(this.username) && enteredPassword.equals(this.password);
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