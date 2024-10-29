/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog_a1_st10449515_p1;
import javax.swing.JOptionPane;
/**
 *
 * @author Thandwa
 */

public class Tasks {

    private int totalHours = 0; // To track the total hours of all tasks
    private int taskCount = 0;  // For TaskID generation and task number
    private int maxTasks;       // Maximum number of tasks user wishes to enter

    public Tasks() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Allow user to specify the number of tasks
        maxTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));

        boolean continueProgram = true;

        // Menu loop
        while (continueProgram) {
            String choice = JOptionPane.showInputDialog(null, "Select an option:\n1) Add Tasks\n2) Show Report (Coming Soon)\n3) Quit");

            try {
                int option = Integer.parseInt(choice);

                switch (option) {
                    case 1:
                        addTasks();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case 3:
                        quit();
                        continueProgram = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please select a valid number.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    // Method to add tasks based on user-defined task limit
    public void addTasks() {
        for (int i = 0; i < maxTasks; i++) {
            String taskName, taskDescription, developerDetails, taskStatus;
            int taskDuration;

            // Task Name
            taskName = JOptionPane.showInputDialog("Enter the task name:");

            // Task Description
            do {
                taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
            } while (!checkTaskDescription(taskDescription));

            // Developer Details
            developerDetails = JOptionPane.showInputDialog("Enter developer's first and last name:");

            // Task Duration
            taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
            totalHours += taskDuration;

            // Task Status
            taskStatus = JOptionPane.showInputDialog("Select task status:\n1) To Do\n2) Doing\n3) Done");

            // Create Task ID
            String taskID = createTaskID(taskName, developerDetails);

            // Display Task Details in the required order
            String taskDetails = printTaskDetails(taskStatus, developerDetails, taskName, taskDescription, taskID, taskDuration);
            JOptionPane.showMessageDialog(null, taskDetails);
        }

        // Display total hours across all tasks after all tasks are entered
        JOptionPane.showMessageDialog(null, "Total hours of all tasks: " + returnTotalHours() + " hours");
    }

    // Method to check if task description is not more than 50 characters
    public boolean checkTaskDescription(String taskDescription) {
        if (taskDescription.length() <= 50) {
            JOptionPane.showMessageDialog(null, "Task successfully captured.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
            return false;
        }
    }

    // Method to create and return the taskID based on task name and developer details
    public String createTaskID(String taskName, String developerDetails) {
        taskCount++;
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" + taskCount + ":" +
                        developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskID;
    }

    // Method to return formatted task details
    public String printTaskDetails(String taskStatus, String developerDetails, String taskName, String taskDescription, String taskID, int taskDuration) {
        return "Task Details:\n" +
               "Status: " + taskStatus + "\n" +
               "Developer: " + developerDetails + "\n" +
               "Task Number: " + taskCount + "\n" +
               "Task Name: " + taskName + "\n" +
               "Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + " hours";
    }

    // Method to return the total combined hours of all entered tasks
    public int returnTotalHours() {
        return totalHours;
    }

    // Method to quit the application
    public void quit() {
        JOptionPane.showMessageDialog(null, "Exiting the program. Goodbye!");
    }
}
