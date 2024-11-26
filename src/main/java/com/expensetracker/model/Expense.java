package com.expensetracker.model;


// Represents an individual expense with a description and an amount.
public class Expense {
    private String description; // A short description of the expense
    private double amount;      // The monetary value of the expense

    // Constructor to initialize an Expense object
    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    // Getter for the description of the expense
    public String getDescription() {
        return description;
    }

    // Getter for the amount of the expense
    public double getAmount() {
        return amount;
    }

    // Overrides toString() to provide a readable representation of an Expense
    @Override
    public String toString() {
        return description + ": $" + amount;
    }
}

