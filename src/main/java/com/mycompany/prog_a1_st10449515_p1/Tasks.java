/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog_a1_st10449515_p1;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Thandwa
 */
public class Tasks {

    // Arrays to store task-related data
    private ArrayList<String> developers = new ArrayList<>();
    private ArrayList<String> taskNames = new ArrayList<>();
    private ArrayList<String> taskDescriptions = new ArrayList<>();
    private ArrayList<String> taskIDs = new ArrayList<>();
    private ArrayList<Integer> taskDurations = new ArrayList<>();
    private ArrayList<String> taskStatuses = new ArrayList<>();

    /**
     * Constructor for the Tasks class.
     * Displays a welcome message when an object of the class is created.
     */
    public Tasks() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");
    }

    // ----------- Methods for First TaskTest -------------

    /**
     * Validates that the task description is less than or equal to 50 characters.
     * @param taskDescription The task description to validate.
     * @return True if the description is valid, otherwise false.
     */
    public boolean checkTaskDescription(String taskDescription) {
        return taskDescription.length() <= 50;
    }

    /**
     * Generates a task ID based on task name, task number, and developer's name.
     * @param taskName The name of the task.
     * @param developerName The developer assigned to the task.
     * @return The generated task ID.
     */
    public String generateTaskID(String taskName, String developerName) {
        int taskNumber = taskNames.size() + 1;
        return taskName.substring(0, 2).toUpperCase() + ":" +
               taskNumber + ":" +
               developerName.substring(developerName.length() - 3).toUpperCase();
    }

    /**
     * Adds a task to the task list.
     * This method includes validation for task description and generates a task ID.
     * @param taskName Name of the task.
     * @param taskDescription Description of the task (must be <= 50 characters).
     * @param developer Name of the developer.
     * @param duration Duration in hours.
     * @param status Status of the task (e.g., "To Do", "Doing", "Done").
     */
    public void addTask(String taskName, String taskDescription, String developer, int duration, String status) {
        if (!checkTaskDescription(taskDescription)) {
            throw new IllegalArgumentException("Task description must be 50 characters or less.");
        }

        String taskID = generateTaskID(taskName, developer);

        developers.add(developer);
        taskNames.add(taskName);
        taskDescriptions.add(taskDescription);
        taskIDs.add(taskID);
        taskDurations.add(duration);
        taskStatuses.add(status);
    }

    /**
     * Returns the total number of tasks in the list.
     * @return Total number of tasks.
     */
    public int returnTotalHours() {
        return taskDurations.size();
    }

    // ----------- Methods for TaskTest2 (unchanged) -------------

    /**
     * Populates the class arrays with predefined test data.
     * This method is useful for testing purposes.
     */
    public void populateTestData() {
        developers.add("Mike Smith");
        developers.add("Edward Harrison");
        developers.add("Samantha Paulson");
        developers.add("Glenda Oberholzer");

        taskNames.add("Create Login");
        taskNames.add("Create Add Features");
        taskNames.add("Create Reports");
        taskNames.add("Add Arrays");

        taskDurations.add(5);
        taskDurations.add(8);
        taskDurations.add(2);
        taskDurations.add(11);

        taskStatuses.add("To Do");
        taskStatuses.add("Doing");
        taskStatuses.add("Done");
        taskStatuses.add("To Do");
    }

    /**
     * Returns the developers array as a string array.
     * @return String array of developers.
     */
    public String[] getDevelopers() {
        return developers.toArray(new String[0]);
    }

    /**
     * Finds the developer assigned to the task with the longest duration.
     * @return Name of the developer for the longest task.
     */
    public String getDeveloperForLongestTask() {
        int longestIndex = 0;
        for (int i = 1; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > taskDurations.get(longestIndex)) {
                longestIndex = i;
            }
        }
        return developers.get(longestIndex);
    }

    /**
     * Returns the duration of the task with the longest time.
     * @return Duration of the longest task in hours.
     */
    public int getLongestTaskDuration() {
        int longestDuration = 0;
        for (int duration : taskDurations) {
            if (duration > longestDuration) {
                longestDuration = duration;
            }
        }
        return longestDuration;
    }

    /**
     * Searches for a task by name and returns its details.
     * @param taskName The name of the task to search for.
     * @return Array containing developer name, task name, and status, or null if not found.
     */
    public String[] searchTaskByName(String taskName) {
        int index = taskNames.indexOf(taskName);
        if (index != -1) {
            return new String[]{developers.get(index), taskNames.get(index), taskStatuses.get(index)};
        }
        return null;
    }

    /**
     * Searches for tasks assigned to a specific developer.
     * @param developerName The name of the developer.
     * @return Array of task names assigned to the developer.
     */
    public String[] searchTasksByDeveloper(String developerName) {
        ArrayList<String> tasksForDeveloper = new ArrayList<>();
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developerName)) {
                tasksForDeveloper.add(taskNames.get(i));
            }
        }
        return tasksForDeveloper.toArray(new String[0]);
    }

    /**
     * Deletes a task by its name.
     * @param taskName The name of the task to delete.
     * @return True if the task was deleted, false otherwise.
     */
    public boolean deleteTaskByName(String taskName) {
        int index = taskNames.indexOf(taskName);
        if (index != -1) {
            developers.remove(index);
            taskNames.remove(index);
            taskDescriptions.remove(index);
            taskIDs.remove(index);
            taskDurations.remove(index);
            taskStatuses.remove(index);
            return true;
        }
        return false;
    }

    /**
     * Generates a full report of all tasks.
     * @return A string report of all tasks with their details.
     */
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < taskNames.size(); i++) {
            report.append("Developer: ").append(developers.get(i))
                  .append(", Task Name: ").append(taskNames.get(i))
                  .append(", Duration: ").append(taskDurations.get(i))
                  .append(", Status: ").append(taskStatuses.get(i))
                  .append("\n");
        }
        return report.toString();
    }
}