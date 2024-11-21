package com.mycompany.prog_a1_st10449515_p1;

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
public class TasksTest {

    private Tasks tasks = new Tasks();

    @Test
    void testCheckTaskDescription() {
        // Test that descriptions <= 50 characters pass and others fail
        assertTrue(tasks.checkTaskDescription("Create Login to authenticate users"));
        assertFalse(tasks.checkTaskDescription("This description is intentionally over fifty characters to test."));
    }

    @Test
    void testGenerateTaskID() {
        // Testing the task ID generation logic based on task name and developer's name
        String taskID1 = tasks.generateTaskID("Login Feature", "Robyn Harrison");
        // "Login Feature" => "LO", "Robyn Harrison" => "SON" (last three chars of "Harrison")
        assertEquals("LO:1:SON", taskID1); 

        String taskID2 = tasks.generateTaskID("Add Feature", "Mike Smith");
        // "Add Feature" => "AD", "Mike Smith" => "ITH" (last three chars of "Smith")
        assertEquals("AD:2:ITH", taskID2); 
    }

    @Test
    void testAddTask() {
        // Add a task and assert the total hours are updated correctly
        tasks.addTask("Login Feature", "Create Login", "Robyn Harrison", 8, "To Do");
        
        // Assuming returnTotalHours() returns the total hours of all tasks in the system.
        assertEquals(8, tasks.returnTotalHours());  // Checking the total hours after adding a task.
    }

    // If you want to test other methods like deleting tasks or retrieving reports, you can add those here.
}