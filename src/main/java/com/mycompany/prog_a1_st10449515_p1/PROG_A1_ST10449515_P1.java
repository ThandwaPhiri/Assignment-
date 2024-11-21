/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog_a1_st10449515_p1;
import javax.swing.JOptionPane;


/**
 *
 * @author Thandwa
 */

/**
 * Main class to run the EasyKanban application.
 * Handles user registration, login, and launching the task management system.
 */
public class PROG_A1_ST10449515_P1 {

    public static void main(String[] args) {
        // Create a register object to handle user registration and login
        register userRegistration = new register();

        // Declare user details
        String username;
        String password;
        String firstName;
        String lastName;

        // Prompt for user registration
        username = JOptionPane.showInputDialog("Create a username (at least 5 characters and must contain an underscore):");
        while (!userRegistration.checkUserName(username)) {
            JOptionPane.showMessageDialog(null, "Error: Username must be at least 5 characters long and contain an underscore (_). Please try again.");
            username = JOptionPane.showInputDialog("Create a username (at least 5 characters and must contain an underscore):");
        }

        password = JOptionPane.showInputDialog("Create a password (at least 8 characters, must contain a number, a capital letter, and a special character):");
        while (!userRegistration.checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null, "Error: Password must be at least 8 characters long, contain a number, a capital letter, and a special character. Please try again.");
            password = JOptionPane.showInputDialog("Create a password (at least 8 characters, must contain a number, a capital letter, and a special character):");
        }

        firstName = JOptionPane.showInputDialog("Enter your first name:");
        lastName = JOptionPane.showInputDialog("Enter your last name:");

        // Register the user
        String registrationResult = userRegistration.registerUser(username, password);
        JOptionPane.showMessageDialog(null, registrationResult);

        // User login
        username = JOptionPane.showInputDialog("Enter your Username to login:");
        password = JOptionPane.showInputDialog("Enter your Password to login:");
        boolean isLoginSuccessful = userRegistration.loginUser(username, password);

        // Display login status
        String loginStatus = userRegistration.returnLoginStatus(isLoginSuccessful, firstName, lastName);
        JOptionPane.showMessageDialog(null, loginStatus);

        // Launch the task management menu if login is successful
        if (isLoginSuccessful) {
            new Tasks(); // Launch EasyKanban
        }
    }
}