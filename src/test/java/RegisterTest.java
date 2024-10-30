/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */



import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Thandwa
 */
class RegisterTest {

    private register register;

    @BeforeEach
    void setUp() {
        register = new register();
    }

    @Test
    void testUsernameCorrectlyFormatted() {
        // Test with a correctly formatted username
        String username = "kyl_1";
        String expectedMessage = "Welcome <user first name> <user last name>, it is great to see you.";
        assertEquals(expectedMessage, register.checkUsernameFormat(username));
    }

    @Test
    void testUsernameIncorrectlyFormatted() {
        // Test with an incorrectly formatted username
        String username = "kyle!!!!!!";
        String expectedMessage = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        assertEquals(expectedMessage, register.checkUsernameFormat(username));
    }

    @Test
    void testPasswordMeetsComplexity() {
        // Test with a password that meets the complexity requirements
        String password = "Ch&&sec@ke99!";
        String expectedMessage = "Password successfully captured";
        assertEquals(expectedMessage, register.checkPasswordComplexity(password));
    }

    @Test
    void testPasswordDoesNotMeetComplexity() {
        // Test with a password that does not meet the complexity requirements
        String password = "password";
        String expectedMessage = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        assertEquals(expectedMessage, register.checkPasswordComplexity(password));
    }

    @Test
    void testLoginSuccessful() {
        // Test for a successful login (assuming the Register class has a login method that returns true for successful logins)
        assertTrue(register.login("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    void testLoginFailed() {
        // Test for a failed login
        assertFalse(register.login("kyl_1", "wrongPassword"));
    }

    @Test
    void testUsernameCorrectlyFormattedBoolean() {
        // Test if the username correctly formatted check returns true
        assertTrue(register.isUsernameCorrectlyFormatted("kyl_1"));
    }

    @Test
    void testUsernameIncorrectlyFormattedBoolean() {
        // Test if the username incorrectly formatted check returns false
        assertFalse(register.isUsernameCorrectlyFormatted("kyle!!!!!!"));
    }

    @Test
    void testPasswordMeetsComplexityBoolean() {
        // Test if the password meets complexity requirements
        assertTrue(register.isPasswordComplex("Ch&&sec@ke99!"));
    }

    @Test
    void testPasswordDoesNotMeetComplexityBoolean() {
        // Test if the password does not meet complexity requirements
        assertFalse(register.isPasswordComplex("password"));
    }
}