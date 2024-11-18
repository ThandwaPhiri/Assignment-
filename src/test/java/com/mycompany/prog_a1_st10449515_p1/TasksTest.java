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
class TasksTest {

    private Tasks tasks = new Tasks();

//    @BeforeEach
//    void setUp() {
//        tasks = new Tasks();
//    }

    @Test
    void testCheckTaskDescription() {
        // Test with valid description (less than 50 characters)
        assertTrue(tasks.checkTaskDescription("Create Login to authenticate users"));

        // Test with invalid description (more than 50 characters)
        assertFalse(tasks.checkTaskDescription("This task description is intentionally longer than fifty characters to test the limit."));
    }

    @Test
    void testCreateTaskID() {
        // Test Task ID generation
        String taskID1 = tasks.createTaskID("Login Feature", 0, "Robyn Harrison");
        assertEquals("LO:0:SON", taskID1);

        String taskID2 = tasks.createTaskID("Add Task Feature", 1, "Mike Smith");
        assertEquals("AD:1:ITH", taskID2);
    }

    @Test
    void testAddTaskAndGetTaskDetailsByIndex() {
        // Add tasks to the tasks list
        tasks.addTask("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        tasks.addTask("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");

        // Expected details for the first task
        String expectedDetails1 = "Task Details:\n" +
                                  "Status: To Do\n" +
                                  "Developer: Robyn Harrison\n" +
                                  "Task Number: 1\n" +
                                  "Task Name: Login Feature\n" +
                                  "Description: Create Login to authenticate users\n" +
                                  "Task ID: LO:1:SON\n" +
                                  "Duration: 8 hours";

        // Expected details for the second task
        String expectedDetails2 = "Task Details:\n" +
                                  "Status: Doing\n" +
                                  "Developer: Mike Smith\n" +
                                  "Task Number: 2\n" +
                                  "Task Name: Add Task Feature\n" +
                                  "Description: Create Add Task feature to add task users\n" +
                                  "Task ID: AD:2:ITH\n" +
                                  "Duration: 10 hours";

        // Assert that the details match the expected output
        assertEquals(expectedDetails1, tasks.getTaskDetailsByIndex(0));
        assertEquals(expectedDetails2, tasks.getTaskDetailsByIndex(1));
    }

    @Test
    void testReturnTotalHours() {
        // Adding tasks with durations
        tasks.addTask("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, "To Do");
        tasks.addTask("Add Task Feature", "Create Add Task feature to add task users", "Mike Smith", 10, "Doing");

        // Testing total hours calculation
        assertEquals(18, tasks.returnTotalHours());
    }
}