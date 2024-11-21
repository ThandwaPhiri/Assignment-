/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog_a1_st10449515_p1;

/**
 *
 * @author Thandwa
 */
/**
 * Handles user registration and login functionality.
 */
public class register {

    private String registeredUsername; // Stores the registered username
    private String registeredPassword; // Stores the registered password

    /**
     * Validates the username format.
     * 
     * @param username the username to validate
     * @return true if valid, false otherwise
     */
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() >= 5;
    }

    /**
     * Validates password complexity.
     * 
     * @param password the password to validate
     * @return true if valid, false otherwise
     */
    public boolean checkPasswordComplexity(String password) {
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()].*");
        return password.length() >= 8 && hasDigit && hasUppercase && hasSpecialChar;
    }

    /**
     * Registers a user with a username and password.
     * 
     * @param username the username to register
     * @param password the password to register
     * @return a success or error message
     */
    public String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Error: Invalid username format.";
        } else if (!checkPasswordComplexity(password)) {
            return "Error: Invalid password format.";
        } else {
            this.registeredUsername = username;
            this.registeredPassword = password;
            return "User successfully registered!";
        }
    }

    /**
     * Validates login credentials.
     * 
     * @param username the entered username
     * @param password the entered password
     * @return true if login is successful, false otherwise
     */
    public boolean loginUser(String username, String password) {
        return username.equals(this.registeredUsername) && password.equals(this.registeredPassword);
    }

    /**
     * Returns a login status message.
     * 
     * @param isSuccess indicates if login was successful
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @return the status message
     */
    public String returnLoginStatus(boolean isSuccess, String firstName, String lastName) {
        if (isSuccess) {
            return "Welcome " + firstName + " " + lastName + "! Great to see you again.";
        } else {
            return "Error: Login failed. Please check your username and password.";
        }
    }
}