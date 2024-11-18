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

    private int totalHours = 0; // To track the total hours of all tasks
    private int taskCount = 0;  // For TaskID generation and task number
    private int maxTasks;       // Maximum number of tasks user wishes to enter

    // List to store each task's details
    private ArrayList<Task> tasksList = new ArrayList<>();

    public Tasks() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Allow user to specify the number of tasks
        maxTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));

        boolean continueProgram = true;

        // Menu loop
        while (continueProgram) {
            String choice = JOptionPane.showInputDialog(null, "Select an option:\n1) Add Tasks\n2) Show Report \n3) Quit");

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
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please select a valid number.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    // Method to add tasks based on the user-defined task limit
    public void addTasks() {
        for (int i = 0; i < maxTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter the task name:");
            String taskDescription;

            // Task Description
            do {
                taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
            } while (!checkTaskDescription(taskDescription));

            String developerDetails = JOptionPane.showInputDialog("Enter developer's first and last name:");
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
            String taskStatus = JOptionPane.showInputDialog("Select task status:\n1) To Do\n2) Doing\n3) Done");

            // Increment task count for ID generation
            taskCount++;
            String taskID = createTaskID(taskName, taskCount, developerDetails);

            // Add task to the list
            addTask(taskName, taskDescription, developerDetails, taskDuration, taskStatus);

            // Display the details of the added task
            JOptionPane.showMessageDialog(null, getTaskDetailsByIndex(taskCount - 1));
        }

        // Show total hours once all tasks are entered
        JOptionPane.showMessageDialog(null, "Total hours of all tasks: " + returnTotalHours() + " hours");
    }

    // Method to validate task description length
    public boolean checkTaskDescription(String description) {
        if (description.length() <= 50) {
            JOptionPane.showMessageDialog(null, "Task successfully captured.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
            return false;
        }
    }

    // Method to generate Task ID
    public String createTaskID(String taskName, int taskNumber, String developer) {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" +
               developer.substring(developer.length() - 3).toUpperCase();
    }

    // Method to add a task to the list
    public void addTask(String taskName, String taskDescription, String developerDetails, int duration, String status) {
        String taskID = createTaskID(taskName, taskCount, developerDetails);
        tasksList.add(new Task(taskName, taskCount, taskDescription, developerDetails, duration, status, taskID));
        totalHours += duration;
    }

    // Method to retrieve task details by index
    public String getTaskDetailsByIndex(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasksList.size()) {
            Task task = tasksList.get(taskIndex);
            return "Task Details:\n" +
                   "Status: " + task.status + "\n" +
                   "Developer: " + task.developerDetails + "\n" +
                   "Task Number: " + task.taskNumber + "\n" +
                   "Task Name: " + task.taskName + "\n" +
                   "Description: " + task.taskDescription + "\n" +
                   "Task ID: " + task.taskID + "\n" +
                   "Duration: " + task.taskDuration + " hours";
        }
        return "Invalid task index.";
    }

    // Method to return the total combined hours of all entered tasks
    public int returnTotalHours() {
        return totalHours;
    }


    // Inner class to represent a task
    private class Task {
        String taskName;
        int taskNumber;
        String taskDescription;
        String developerDetails;
        int taskDuration;
        String status;
        String taskID;

        Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String status, String taskID) {
            this.taskName = taskName;
            this.taskNumber = taskNumber;
            this.taskDescription = taskDescription;
            this.developerDetails = developerDetails;
            this.taskDuration = taskDuration;
            this.status = status;
            this.taskID = taskID;
        }
    }
}