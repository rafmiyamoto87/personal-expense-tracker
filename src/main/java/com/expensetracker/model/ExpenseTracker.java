package com.expensetracker.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Manages the expense data organized by categories
public class ExpenseTracker {
    // HashMap where keys are categories (e.g., "Food") and values are lists of expenses in that category
    private Map<String, List<Expense>> expenses;

    // Constructor initializes the HashMap
    public ExpenseTracker() {
        this.expenses = new HashMap<>();
    }

    // Adds a new expense to a specific category
    public void addExpense(String category, double amount, String description) {
        // If the category doesn't exist, create a new list for it
        expenses.putIfAbsent(category, new ArrayList<>());
        // Add the expense to the list of the specified category
        expenses.get(category).add(new Expense(description, amount));
        System.out.println("Expense added: " + description + " - $" + amount + " in " + category);
    }

    // Displays all expenses under a specific category
    public void viewExpensesByCategory(String category) {
        // Check if the category exists
        if (!expenses.containsKey(category)) {
            System.out.println("No expenses found for category: " + category);
            return;
        }

        // Retrieve the list of expenses for the category
        List<Expense> categoryExpenses = expenses.get(category);
        double total = 0;
        System.out.println("Expenses for category: " + category);

        // Iterate over the expenses and display them
        for (Expense expense : categoryExpenses) {
            System.out.println("- " + expense); // Uses Expense's toString() method
            total += expense.getAmount(); // Calculate the total amount spent in the category
        }
        System.out.println("Total: $" + total);
    }

    // Displays all expenses across all categories
    public void viewAllExpenses() {
        // Check if there are any expenses recorded
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }

        double grandTotal = 0;
        System.out.println("All Expenses:");

        // Iterate over each category in the HashMap
        for (Map.Entry<String, List<Expense>> entry : expenses.entrySet()) {
            String category = entry.getKey(); // The category name
            List<Expense> categoryExpenses = entry.getValue(); // The list of expenses in this category
            double categoryTotal = 0;

            System.out.println("Category: " + category);
            for (Expense expense : categoryExpenses) {
                System.out.println("- " + expense); // Display each expense
                categoryTotal += expense.getAmount(); // Calculate the total for this category
            }
            System.out.println("Total for " + category + ": $" + categoryTotal);
            grandTotal += categoryTotal; // Add to the overall total
        }
        System.out.println("Grand Total: $" + grandTotal);
    }

    // Removes a specific expense from a category
    public void removeExpense(String category, String description) {
        // Check if the category exists
        if (!expenses.containsKey(category)) {
            System.out.println("Category not found.");
            return;
        }

        // Get the list of expenses for the category
        List<Expense> categoryExpenses = expenses.get(category);

        // Remove the expense that matches the description
        categoryExpenses.removeIf(expense -> expense.getDescription().equalsIgnoreCase(description));
        System.out.println("Removed expense: " + description + " from category " + category);

        // If the category becomes empty after removal, remove it from the HashMap
        if (categoryExpenses.isEmpty()) {
            expenses.remove(category);
        }
    }

    // Analyzes spending and finds the category with the highest total
    public void analyzeSpending() {
        // Check if there are any expenses recorded
        if (expenses.isEmpty()) {
            System.out.println("No expenses to analyze.");
            return;
        }

        String highestCategory = null;
        double highestTotal = 0;

        // Iterate over each category to calculate totals
        for (Map.Entry<String, List<Expense>> entry : expenses.entrySet()) {
            double categoryTotal = 0;
            for (Expense expense : entry.getValue()) {
                categoryTotal += expense.getAmount(); // Sum up expenses for the category
            }

            // Update the highest category if this one has a larger total
            if (categoryTotal > highestTotal) {
                highestTotal = categoryTotal;
                highestCategory = entry.getKey();
            }
        }

        System.out.println("Category with highest spending: " + highestCategory + " - $" + highestTotal);
    }
}