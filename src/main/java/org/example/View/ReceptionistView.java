package org.example.View;

import java.util.Scanner;

public class ReceptionistView {

    private Scanner scanner;

    public ReceptionistView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Receptionist System!");
    }

    public void displayOptions() {
        System.out.println("1. Check-in Guest");
        System.out.println("2. Check-out Guest");
        System.out.println("3. Make Reservation");
        System.out.println("4. Cancel Reservation");
        System.out.println("5. Exit Receptionist System");
        System.out.print("Enter your choice: ");
    }

    public int getChoice() {
        return scanner.nextInt();
    }

    public String getRoomType() {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the room type (Single/Double/Deluxe/VIP): ");
        return scanner.nextLine();
    }

    public String getGuestName() {
        System.out.print("Enter guest name: ");
        return scanner.nextLine();
    }

    public String getRoomNumber() {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the room number: ");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}