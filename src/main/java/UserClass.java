/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thandwa
 */
public class UserClass {
    private String UserName;
    private String Password;
    private String firstName;
    private String lastName;
    
    //Initializing objects in the class
    public UserClass(String UserName, String Password, String firstName, String lastName){
        this.UserName = UserName;
        this.Password = Password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    //Setting up methods to check if the username contains an underscore and is not longer than 5 characters
    public boolean checkUserName(){
        return UserName.contains("_") && UserName.length() <= 5;
    }
    
    //Setting up Methods to check the users password complexity
    public boolean checkPasswordComplexity(){
        return Password.length() >=8 && Password.matches(".*[A-Z].*") && Password.matches(".*[0-9].*") && Password.matches(".*[!@#$%^&*()].*");
    }
    // Setters & Getters
     public String getUsername() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }
    
    public String getPassword() {
        return Password;
    }
    
    public void setPassword(String password) {
        this.Password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
} 
