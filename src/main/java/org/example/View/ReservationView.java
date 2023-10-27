package org.example.View;

import java.util.Scanner;

public class ReservationView {

    private Scanner scanner;

    public ReservationView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Reservation System!");
    }

    public void displayOptions() {
        System.out.println("1. Make Reservation");
        System.out.println("2. Cancel Reservation");
        System.out.println("3. View Reservations");
        System.out.println("4. View Available Rooms");
        System.out.println("5. View Reserved Rooms");
        System.out.println("6. Exit");
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