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

    // ArrayLists to store task-related data
    private ArrayList<String> developers = new ArrayList<>();
    private ArrayList<String> taskNames = new ArrayList<>();
    private ArrayList<String> taskIDs = new ArrayList<>();
    private ArrayList<Integer> taskDurations = new ArrayList<>();
    private ArrayList<String> taskStatuses = new ArrayList<>();

    // Constructor: Initializes the program and displays a welcome message
    public Tasks() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");

        boolean continueProgram = true;

        // Main menu loop
        while (continueProgram) {
            String choice = JOptionPane.showInputDialog(null, "Select an option:\n" +
                    "1) Add a Task\n" +
                    "2) View Tasks by Status 'Done'\n" +
                    "3) View Task with Longest Duration\n" +
                    "4) Search Task by Name\n" +
                    "5) Search Tasks by Developer\n" +
                    "6) Delete Task by Name\n" +
                    "7) Display Full Task Report\n" +
                    "8) Exit");

            try {
                int option = Integer.parseInt(choice);

                // Handle menu options using a switch statement
                switch (option) {
                    case 1 -> addTask(); // Add a new task
                    case 2 -> displayTasksByStatus("Done"); // View tasks with status 'Done'
                    case 3 -> displayLongestTask(); // View task with the longest duration
                    case 4 -> searchTaskByName(); // Search for a task by name
                    case 5 -> searchTasksByDeveloper(); // Search for tasks by developer
                    case 6 -> deleteTaskByName(); // Delete a task by name
                    case 7 -> displayFullTaskReport(); // Display a full report of all tasks
                    case 8 -> { // Exit the program
                        JOptionPane.showMessageDialog(null, "Exiting EasyKanban. Goodbye!");
                        continueProgram = false;
                    }
                    default -> JOptionPane.showMessageDialog(null, "Invalid option. Please select a valid number.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    // Adds a new task to the system
    private void addTask() {
        String taskName = JOptionPane.showInputDialog("Enter the task name:");

        // Ensure task description is within the 50-character limit
        String taskDescription;
        do {
            taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
        } while (taskDescription.length() > 50);

        String developer = JOptionPane.showInputDialog("Enter developer's first and last name:");
        int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));

        // Prompt user to select a task status
        String[] statusOptions = {"To Do", "Doing", "Done"};
        String status = (String) JOptionPane.showInputDialog(null, "Select task status:",
                "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

        // Generate a unique Task ID
        String taskID = generateTaskID(taskName, developer);

        // Add task details to the respective ArrayLists
        developers.add(developer);
        taskNames.add(taskName);
        taskIDs.add(taskID);
        taskDurations.add(duration);
        taskStatuses.add(status);

        JOptionPane.showMessageDialog(null, "Task successfully added!\nTask ID: " + taskID);
    }

    // Generates a unique Task ID based on the task name and developer
    private String generateTaskID(String taskName, String developer) {
        return taskName.substring(0, 2).toUpperCase() + ":" +
                (taskNames.size() + 1) + ":" +
                developer.substring(developer.length() - 3).toUpperCase();
    }

    // Displays tasks filtered by their status
    private void displayTasksByStatus(String status) {
        StringBuilder result = new StringBuilder("Tasks with status '" + status + "':\n\n");

        for (int i = 0; i < taskStatuses.size(); i++) {
            if (taskStatuses.get(i).equalsIgnoreCase(status)) {
                result.append("Developer: ").append(developers.get(i)).append("\n")
                        .append("Task Name: ").append(taskNames.get(i)).append("\n")
                        .append("Duration: ").append(taskDurations.get(i)).append(" hours\n\n");
            }
        }

        JOptionPane.showMessageDialog(null, result.toString());
    }

    // Finds and displays the task with the longest duration
    private void displayLongestTask() {
        int longestIndex = 0;
        for (int i = 1; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > taskDurations.get(longestIndex)) {
                longestIndex = i;
            }
        }

        JOptionPane.showMessageDialog(null, "Task with Longest Duration:\n" +
                "Developer: " + developers.get(longestIndex) + "\n" +
                "Task Name: " + taskNames.get(longestIndex) + "\n" +
                "Duration: " + taskDurations.get(longestIndex) + " hours");
    }

    // Searches for a specific task by its name
    private void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter the task name to search for:");
        int index = taskNames.indexOf(taskName);

        if (index != -1) {
            JOptionPane.showMessageDialog(null, "Task Found:\n" +
                    "Developer: " + developers.get(index) + "\n" +
                    "Task Name: " + taskNames.get(index) + "\n" +
                    "Status: " + taskStatuses.get(index));
        } else {
            JOptionPane.showMessageDialog(null, "Task not found.");
        }
    }

    // Searches for all tasks assigned to a specific developer
    private void searchTasksByDeveloper() {
        String developer = JOptionPane.showInputDialog("Enter the developer's name to search for:");
        StringBuilder result = new StringBuilder("Tasks for Developer '" + developer + "':\n\n");

        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developer)) {
                result.append("Task Name: ").append(taskNames.get(i)).append("\n")
                        .append("Status: ").append(taskStatuses.get(i)).append("\n\n");
            }
        }

        JOptionPane.showMessageDialog(null, result.toString());
    }

    // Deletes a task by its name
    private void deleteTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter the task name to delete:");
        int index = taskNames.indexOf(taskName);

        if (index != -1) {
            // Remove task details from all ArrayLists
            developers.remove(index);
            taskNames.remove(index);
            taskIDs.remove(index);
            taskDurations.remove(index);
            taskStatuses.remove(index);

            JOptionPane.showMessageDialog(null, "Task deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Task not found.");
        }
    }

    // Displays a full report of all tasks
    private void displayFullTaskReport() {
        StringBuilder report = new StringBuilder("Full Task Report:\n\n");

        for (int i = 0; i < taskNames.size(); i++) {
            report.append("Task ID: ").append(taskIDs.get(i)).append("\n")
                    .append("Developer: ").append(developers.get(i)).append("\n")
                    .append("Task Name: ").append(taskNames.get(i)).append("\n")
                    .append("Duration: ").append(taskDurations.get(i)).append(" hours\n")
                    .append("Status: ").append(taskStatuses.get(i)).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, report.toString());
    }
}