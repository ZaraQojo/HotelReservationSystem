package org.example.View;

import java.util.Scanner;

public class SignUpView {

    private Scanner scanner;

    public SignUpView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to Sign Up!");
    }

    public String getUsername() {
        System.out.print("Enter your username: ");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.print("Enter your password: ");
        return scanner.nextLine();
    }

    public void displaySuccessMessage(String role) {
        System.out.println("Account created successfully. You are now a " + role);
    }

    public void displayErrorMessage() {
        System.out.println("Account creation failed. Username already exists.");
    }
}