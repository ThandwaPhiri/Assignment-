/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog_a1_st10449515_p1;
import java.util.Scanner;


/**
 *
 * @author Thandwa
 */
public class PROG_A1_ST10449515_P1 {
    
    public static void main(String[] args) {
        // Declarations
        String Username;
        String Password;
        String firstName;
        String lastName;
        
        Scanner scanner = new Scanner(System.in);
        
        // Prompting the user to enter their Username
        System.out.print("Enter your Username: ");
        Username = scanner.nextLine();
        
        // Prompting the user to enter their Password
        System.out.println("Enter your Password: ");
        Password = scanner.nextLine();
        
        // Prompting a user to enter their First Name
        System.out.println("Enter your First Name: ");
        firstName = scanner.nextLine();
        
        // Prompting a user to enter their Last Name
        System.out.println("Enter your Last Name: ");
        lastName = scanner.nextLine();
        
        // Here we create a new user object
        UserClass1 user = new UserClass1(Username, Password, firstName, lastName);
        
        // Here we create a new Login handler
        LoginClass1 loginHandler = new LoginClass1(user);
        
        // Attempt to register the user
        String registrationMessage = loginHandler.registerUser();
        System.out.println(registrationMessage);  // Print registration feedback
        
        // Proceed only if registration was successful
        if (registrationMessage.contains("successfully captured")) {
            //Here we prompt for login credentials
            System.out.print("Enter your Username for login: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter your Password for login: ");
            String loginPassword = scanner.nextLine();
            
            // Attempt to login
            boolean loginSuccessful = loginHandler.loginUser(loginUsername, loginPassword);
            String loginStatus = loginHandler.returnLoginStatus(loginSuccessful);
            System.out.println(loginStatus);  // Output login status
        } else {
            System.out.println("Registration failed, cannot proceed with login.");
        }
    }
}