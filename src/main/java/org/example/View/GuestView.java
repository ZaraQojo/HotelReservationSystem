package org.example.View;

import java.util.Scanner;

public class GuestView {

    private Scanner scanner;

    public GuestView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Guest System!");
    }

    public void displayWelcomeMessage(String s) {
        System.out.println(s);
    }

    public void displayOptions() {
        System.out.println("1. View Available Rooms");
        System.out.println("2. Make Reservation");
        System.out.println("3. View Reserved Rooms");
        System.out.println("4. Exit Guest System");
        System.out.print("Enter your choice: ");
    }

    public int getChoice() {
        return scanner.nextInt();
    }

    public void displayAvailableRooms(String availableRooms) {
        System.out.println("Available Rooms:");
        System.out.println(availableRooms);
    }

    public String getRoomType() {
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the room type (Single/Double/Deluxe/VIP): ");
        return scanner.nextLine();
    }

    public void displayReservedRooms(String reservedRooms) {
        System.out.println("Reserved Rooms:");
        System.out.println(reservedRooms);
    }
}