/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog_a1_st10449515_p1;
import java.util.*;
import javax.swing.JOptionPane;


/**
 *
 * @author Thandwa
 */
public class PROG_A1_ST10449515_P1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        register registerObj = new register(); 
        
        // Declarations
        String Username;
        String Password;
        String firstName;
        String lastName;
        
       
        
        // Prompting the user to enter their Username
        System.out.println("Create a username: ");
        Username = sc.next();
        
        // Check if the username is valid
        while (!registerObj.checkUsername(Username)) {
            System.out.println("Error: Username must be at least 5 characters long and contain an underscore (_). Please try again.");
            System.out.println("Create a username: ");
            Username = sc.next();
        }
        System.out.println("Username successfully captured.");
        
        // Prompting the user to enter their Password
        System.out.println("Create a password: ");
        Password = sc.next();
        
        // Check if the password is valid
        while (!registerObj.checkPassword(Password)) {
            System.out.println("Error: Password must be at least 8 characters long, contain a number, a capital letter, and a special character. Please try again.");
            System.out.println("Create a password: ");
            Password = sc.next();
        }
        System.out.println("Password successfully captured.");
            System.out.println("Enter your firstNamr: ");
            firstName = sc.next();
            
            System.out.println("Enter your lastName: ");
            lastName = sc.next();
            
            
            //Set the userName and Password
            registerObj.setUsername(Username);
            registerObj.setPassword(Password);
            
            System.out.println("Enter your Username to login: ");
            Username = sc.next();
            
            System.out.println("Enter your Password to login: ");
            Password = sc.next();
            
            
            //Attempt to login in with the registered credentials
            boolean isLoginSuccessful = register.loginUser(Username, Password, registerObj.getUsername(), registerObj.getPassword());
            System.out.println(register.returnLoginStatus(isLoginSuccessful,firstName, lastName));
           
        
    
    if (isLoginSuccessful) {
            Tasks taskObj = new Tasks();
        }
        
        // Close the Scanner
        sc.close();
    }
}
