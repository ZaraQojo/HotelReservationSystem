package org.example.Controller;

import org.example.Model.MainModel;
import org.example.View.MainView;

public class MainController {

    private final MainView view;
    private final MainModel model;

    public MainController(MainView view, MainModel model) {
        this.view = view;
        this.model = model;
    }

    public MainController() {

        view = null;
        model = null;
    }

    public void start() {
        // Load data from the JSON file
        model.loadData();

        // Start the user interface
        view.start();
    }

    public void processRequest(String request) {
        if (request.startsWith("BOOK_ROOM")) {
            int roomNumber = Integer.parseInt(request.substring(10));

            // Check room availability using the model
            if (model.isRoomAvailable(roomNumber)) {
                // Book the room using the model
                model.bookRoom(roomNumber);

                // Save the updated data to the JSON file
                model.saveData();

                // Notify the view about successful booking
                view.displayResponse("Room booked successfully.");
            } else {
                // Notify the view about unavailability
                view.displayError("Room not available");
            }
        } else if (request.equals("CHECK_RESERVATIONS")) {
            // Get reservations from the model
            String reservations = model.getReservations();

            // Display the reservations to the user
            view.displayResponse(reservations);
        } else if (request.startsWith("CANCEL_RESERVATION")) {
            int reservationId = Integer.parseInt(request.substring(16));

            // Cancel the reservation using the model
            model.cancelReservation(reservationId);

            // Save the updated data to the JSON file
            model.saveData();

            // Notify the view about successful cancellation
            view.displayResponse("Reservation cancelled successfully.");
        } else {
            // Invalid request
            view.displayError("Invalid request");
        }
    }
}
