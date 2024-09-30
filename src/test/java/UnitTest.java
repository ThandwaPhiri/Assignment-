/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Thandwa
 */
public class UnitTest {

    @Test
    public void testCorrectUsernameFormat() {
        UserClass user = new UserClass("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertTrue(user.checkUserName());
    }

    @Test
    public void testIncorrectUsernameFormat() {
        UserClass user = new UserClass("kyle!!!!!!", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertFalse(user.checkUserName());
    }

    @Test
    public void testPasswordComplexitySuccess() {
        UserClass user = new UserClass("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testPasswordComplexityFailure() {
        UserClass user = new UserClass("kyl_1", "password", "Kyle", "Smith");
        assertFalse(user.checkPasswordComplexity());
    }
    
    @Test
    public void testLoginSuccess() {
        UserClass user = new UserClass("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        LoginClass login = new LoginClass(user);
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailure() {
        UserClass user = new UserClass("kyl_1", "Ch&&sec@ke99!", "Kyle", "Smith");
        LoginClass login = new LoginClass(user);
        assertFalse(login.loginUser("kyl_1", "wrongPassword"));
    }
}
