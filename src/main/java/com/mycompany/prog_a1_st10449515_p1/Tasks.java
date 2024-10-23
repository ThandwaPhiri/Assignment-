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

    public Tasks() {
        // Display welcome message using JOptionPane
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        boolean continueProgram = true;  // Control variable for the loop

        // Loop the menu until the user chooses to quit
        while (continueProgram) {
            String choice;

            // Display menu and get the user choice using JOptionPane
            choice = JOptionPane.showInputDialog(null, "Select an option:\n1) Add Tasks\n2) Show Report\n3) Quit");

            try {
                // Convert the user's choice to an integer
                int option = Integer.parseInt(choice);

                // Handle each case based on the user's input
                switch (option) {
                    case 1:
                        addTasks();
                        break;
                    case 2:
                        showReport();
                        break;
                    case 3:
                        quit();  // Exit the loop and end the program
                        continueProgram = false;  // Set to false to end the loop
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please select a valid number.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }
    }

    // Method for adding tasks (currently simplified)
    public void addTasks() {
        int taskCount = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));
        String[] tasks = new String[taskCount];

        for (int i = 0; i < taskCount; i++) {
            tasks[i] = JOptionPane.showInputDialog("Enter task " + (i + 1) + ":");
        }

        JOptionPane.showMessageDialog(null, "Tasks added successfully!");
    }

    // Method for showing a report
    public void showReport() {
        JOptionPane.showMessageDialog(null, "Report functionality coming soon.");
    }

    // Method for quitting the application
    public void quit() {
        JOptionPane.showMessageDialog(null, "Exiting the program. Goodbye!");
    }
}
