/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog_a1_st10449515_p1;
import java.util.Scanner;
/**
 *
 * @author Thandwa
 */
public class register {
    private String Username;
    private String Password;
    
    public register(){
         this.Username = Username;
         this.Password = Password;
    }
    
    //Getter for Username
    public String getUsername(){
        return Username;
    }
    
    //Setter for Username
    public void setUsername(String Username){
        this.Username = Username;
    }
    
    //Getter for Password
    public String getPassword(){
        return Password;
    }
    
    //Setter for Password
    public void setPassword(String Paswword){
        this.Password = Password;
    }
   
    //Check if the Username is valid
    public boolean checkUsername(String Username){
        //Check if the username contains "-" and is no more than 5 characters
        return Username.contains("_")&& Username.length() <= 5;
        
    }
    
    public boolean checkPassword(String Password){
        boolean hasDigit = false;
        boolean hasCapital =false;
        boolean hasSpecial =false;
        boolean isLong = Password.length() >= 8;
        
        String specialCharacters = "+=-_)(*&^%$#@!";
        
        //Check each character in the password for the required conditions
        for(int i = 0; i < Password.length();i++){
            char result = Password.charAt(i);
            if(Character.isDigit(result)){
                hasDigit = true;
            }
            if (Character.isUpperCase(result)){
                hasCapital = true;
            }
            if(specialCharacters.indexOf(result) >= 0){
                hasSpecial = true;
            }
             
        }
        return hasDigit && hasCapital && hasSpecial && isLong;
    }
    
//Method to log in the user
  public static boolean loginUser(String enteredUsername, String enteredPassword, String storedUsername, String storedPassword){
//Check if the provided credentials match the stored Username and Password
  return enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword);  
}
  
//Public static method to return login success or failure message
  public static String returnLoginStatus(boolean isSuccess, String firstName, String lastName){
      if(isSuccess){
          return "Welcome" + firstName + " " + lastName + ", it is great to see you again!";
      }else{
          return "Username or password validation failed.";
      }
  }
}

   
    
