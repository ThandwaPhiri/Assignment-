/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


package com.mycompany.prog_a1_st10449515_p1;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Thandwa
 */
public class RegisterTest {

    private register register;

    @BeforeEach
    public void setUp() {
        register = new register();
    }

    @Test
    public void testCheckUserName_CorrectlyFormatted() {
        String username = "kyl_1";
        assertTrue(register.checkUserName(username), "Username is correctly formatted.");
    }

    @Test
    public void testCheckUserName_IncorrectlyFormatted() {
        String username = "kyle!!!!!!";
        assertFalse(register.checkUserName(username), "Username is not correctly formatted.");
    }

    @Test
    public void testCheckPasswordComplexity_PasswordMeetsRequirements() {
        String password = "Ch&&sec@ke99!";
        assertTrue(register.checkPasswordComplexity(password), "Password meets the complexity requirements.");
    }

    @Test
    public void testCheckPasswordComplexity_PasswordDoesNotMeetRequirements() {
        String password = "password";
        assertFalse(register.checkPasswordComplexity(password), "Password does not meet the complexity requirements.");
    }

    @Test
    public void testRegisterUser_SuccessfulRegistration() {
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String result = register.registerUser(username, password);
        assertEquals("User successfully registered", result);
    }

    @Test
    public void testRegisterUser_InvalidUsername() {
        String username = "kyle!!!!!!";
        String password = "Ch&&sec@ke99!";
        String result = register.registerUser(username, password);
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", result);
    }

    @Test
    public void testRegisterUser_InvalidPassword() {
        String username = "kyl_1";
        String password = "password";
        String result = register.registerUser(username, password);
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", result);
    }

    @Test
    public void testLoginUser_SuccessfulLogin() {
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        register.registerUser(username, password);
        assertTrue(register.loginUser(username, password), "Login should be successful.");
    }

    @Test
    public void testLoginUser_UnsuccessfulLogin() {
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        register.registerUser(username, password);
        assertFalse(register.loginUser("wrong_user", "wrong_password"), "Login should fail.");
    }

    @Test
    public void testReturnLoginStatus_Success() {
        String firstName = "John";
        String lastName = "Doe";
        String expectedMessage = "Welcome John Doe, it is great to see you again!";
        assertEquals(expectedMessage, register.returnLoginStatus(true, firstName, lastName));
    }

    @Test
    public void testReturnLoginStatus_Failure() {
        String expectedMessage = "Username or password validation failed.";
        assertEquals(expectedMessage, register.returnLoginStatus(false, "", ""));
    }
}