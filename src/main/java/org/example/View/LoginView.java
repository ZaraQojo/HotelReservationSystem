package org.example.View;

import java.util.Scanner;

public class LoginView {

    private final Scanner scanner;

    public LoginView() {
        this.scanner = new Scanner(System.in);
    }

    public int getChoice() {
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public String getUsername() {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter your username: ");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.print("Enter your password: ");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}