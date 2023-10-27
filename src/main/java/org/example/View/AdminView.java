package org.example.View;

import java.util.Scanner;

public class AdminView {

    private Scanner scanner;

    public AdminView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome, Admin!");
    }

    public void displayOptions() {
        System.out.println("1. Add new staff account");
        System.out.println("2. View all staff accounts");
        System.out.println("3. View all guest accounts");
        System.out.println("4. Delete staff account");
        System.out.println("5. Delete guest account");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public int getChoice() {
        return scanner.nextInt();
    }

    public String getUsername() {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the username: ");
        return scanner.nextLine();
    }

    public String getRole() {
        System.out.print("Enter the role (Receptionist/Admin): ");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}