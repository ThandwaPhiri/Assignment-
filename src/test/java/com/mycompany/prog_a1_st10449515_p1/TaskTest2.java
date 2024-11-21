/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog_a1_st10449515_p1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Thandwa
 */
public class TaskTest2 {

    @Test
    public void testDeveloperArrayPopulatedCorrectly() {
        Tasks tasks = new Tasks();

        // Populate arrays with test data
        tasks.populateTestData();

        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        assertArrayEquals(expectedDevelopers, tasks.getDevelopers(), 
            "The developers array should contain the expected test data.");
    }

    @Test
    public void testDisplayTaskWithLongestDuration() {
        Tasks tasks = new Tasks();

        // Populate arrays with test data
        tasks.populateTestData();

        String expectedDeveloper = "Glenda Oberholzer";
        int expectedDuration = 11;

        assertEquals(expectedDeveloper, tasks.getDeveloperForLongestTask(), 
            "The developer for the longest task should match the expected result.");
        assertEquals(expectedDuration, tasks.getLongestTaskDuration(), 
            "The task duration should match the expected result.");
    }

    @Test
    public void testSearchForTaskByName() {
        Tasks tasks = new Tasks();

        // Populate arrays with test data
        tasks.populateTestData();

        String taskName = "Create Login";
        String[] expectedResult = {"Mike Smith", "Create Login", "To Do"};

        assertArrayEquals(expectedResult, tasks.searchTaskByName(taskName), 
            "The search results for the task should match the expected result.");
    }

    @Test
    public void testSearchTasksByDeveloper() {
        Tasks tasks = new Tasks();

        // Populate arrays with test data
        tasks.populateTestData();

        String developerName = "Samantha Paulson";
        String[] expectedResult = {"Create Reports"};

        assertArrayEquals(expectedResult, tasks.searchTasksByDeveloper(developerName), 
            "The tasks assigned to the developer should match the expected result.");
    }

    @Test
    public void testDeleteTaskByName() {
        Tasks tasks = new Tasks();

        // Populate arrays with test data
        tasks.populateTestData();

        String taskNameToDelete = "Create Reports";
        boolean deleteResult = tasks.deleteTaskByName(taskNameToDelete);

        assertTrue(deleteResult, "The task should be successfully deleted.");
        assertNull(tasks.searchTaskByName(taskNameToDelete), 
            "The deleted task should no longer exist.");
    }

    @Test
    public void testDisplayFullReport() {
        Tasks tasks = new Tasks();

        // Populate arrays with test data
        tasks.populateTestData();

        String expectedReport = """
            Developer: Mike Smith, Task Name: Create Login, Duration: 5, Status: To Do
            Developer: Edward Harrison, Task Name: Create Add Features, Duration: 8, Status: Doing
            Developer: Samantha Paulson, Task Name: Create Reports, Duration: 2, Status: Done
            Developer: Glenda Oberholzer, Task Name: Add Arrays, Duration: 11, Status: To Do
            """;

        assertEquals(expectedReport.trim(), tasks.generateReport().trim(), 
            "The generated report should match the expected format and content.");
    }
}