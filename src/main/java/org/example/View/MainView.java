package org.example.View;

import org.example.Controller.MainController;

import java.util.Scanner;

public class MainView {

    private final Scanner scanner;

    public MainView() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        MainController controller = new MainController();
        System.out.println("Welcome to the Hotel Reservation System!");

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Book a room");
            System.out.println("2. Check my reservations");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            System.out.println("5. View available rooms and make a reservation");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Book a room
                    System.out.println("Enter room number:");
                    int roomNumber = scanner.nextInt();
                    System.out.println("Processing request...");

                    // Send room number to the controller
                    controller.processRequest("BOOK_ROOM" + roomNumber);
                    break;

                case 2:
                    // Check my reservations
                    System.out.println("Checking reservations...");

                    // Send request to the controller
                    controller.processRequest("CHECK_RESERVATIONS");
                    break;

                case 3:
                    // Cancel a reservation
                    System.out.println("Enter reservation ID:");
                    int reservationId = scanner.nextInt();
                    System.out.println("Cancelling reservation...");

                    // Send reservation ID to the controller
                    controller.processRequest("CANCEL_RESERVATION" + reservationId);
                    break;

                case 4:
                    // Exit
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                case 5:
                    // View available rooms and make a reservation
                    System.out.println("Viewing available rooms...");

                    // Send request to the controller to get available rooms
                    controller.processRequest("VIEW_AVAILABLE_ROOMS");

                    // Display available rooms
                    System.out.println("Available Rooms:");
                    // Assuming the controller returns a list of available rooms, you can iterate through them
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(i + ". Room " + i);
                    }

                    // Ask the user to select a room
                    System.out.println("Select a room to make a reservation:");
                    int selectedRoom = scanner.nextInt();
                    System.out.println("Processing reservation...");

                    // Send selected room to the controller to make a reservation
                    controller.processRequest("MAKE_RESERVATION" + selectedRoom);
                    break;

                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    public void displayResponse(String response) {

        System.out.println(response);
    }

    public void displayError(String message) {

        System.err.println("Error: " + message);
    }
}
