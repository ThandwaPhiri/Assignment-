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
       //Declarations
        String UserName;
        String Password;
        String firstName;
        String lastName;
        
        
      
        
        Scanner scanner = new Scanner(System.in); 
        
        
        //Prompting the user to enter their Username
         System.out.print("Enter your UserName: ");
         UserName = scanner.nextLine();
        
         //Prompting the user to enter their Password
         System.out.println("Enter your Password: ");
         Password = scanner.nextLine();
         
         //Prompting a user to enter their First Name
         System.out.println("Enter your firstNAme: ");
         firstName = scanner.nextLine();
         
         //Prompting a user to enter their Last Name
         System.out.println("Enter your lastName: ");
         lastName = scanner.nextLine();
         
           // Create a new user
        UserClass1 user = new UserClass1(UserName, Password, firstName, lastName);

        // Create a new login handler
        LoginClass1 loginHandler = new LoginClass1(user);

        // Attempt to register user
        String registrationMessage = loginHandler.registerUser();
        System.out.println(registrationMessage);

        if (!registrationMessage.equals("Registration successful!")) {
            return; // Exit if registration fails
        }

        // Login
        System.out.print("Enter your username for login: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter your password for login: ");
        String loginPassword = scanner.nextLine();

        // Attempt to login
        boolean loginSuccessful = loginHandler.loginUser(loginUsername, loginPassword);
        String loginStatus = loginHandler.returnLoginStatus(loginSuccessful);

        System.out.println(loginStatus);
         
    }
    
}