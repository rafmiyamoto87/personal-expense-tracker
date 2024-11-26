package com.expensetracker.model;

import java.util.Scanner;

// Main class to run the program and handle user input
public class ExpenseTrackerDemo {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker(); // Initialize the ExpenseTracker
        Scanner scanner = new Scanner(System.in);     // Scanner for user input

        while (true) {
            // Display the menu
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses by Category");
            System.out.println("3. View All Expenses");
            System.out.println("4. Remove Expense");
            System.out.println("5. Analyze Spending");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();           // Read user choice
            scanner.nextLine();                       // Consume the newline

            switch (choice) {
                case 1: // Add Expense
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    tracker.addExpense(category, amount, description);
                    break;
                case 2: // View Expenses by Category
                    System.out.print("Enter category: ");
                    category = scanner.nextLine();
                    tracker.viewExpensesByCategory(category);
                    break;
                case 3: // View All Expenses
                    tracker.viewAllExpenses();
                    break;
                case 4: // Remove Expense
                    System.out.print("Enter category: ");
                    category = scanner.nextLine();
                    System.out.print("Enter description: ");
                    description = scanner.nextLine();
                    tracker.removeExpense(category, description);
                    break;
                case 5: // Analyze Spending
                    tracker.analyzeSpending();
                    break;
                case 6: // Exit
                    System.out.println("Exiting. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}