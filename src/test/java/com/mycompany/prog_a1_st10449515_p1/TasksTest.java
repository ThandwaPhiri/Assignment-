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
        assertTrue(tasks.checkTaskDescription("Create Login to authenticate users"));
        assertFalse(tasks.checkTaskDescription("This description is intentionally over fifty characters to test."));
    }

    @Test
    void testGenerateTaskID() {
        String taskID1 = tasks.generateTaskID("Login Feature", "Robyn Harrison");
        assertEquals("LO:1:SON", taskID1);

        String taskID2 = tasks.generateTaskID("Add Feature", "Mike Smith");
        assertEquals("AD:2:ITH", taskID2);
    }

    @Test
    void testAddTask() {
        tasks.addTask("Login Feature", "Create Login", "Robyn Harrison", 8, "To Do");
        assertEquals(1, tasks.returnTotalHours());
    }
}