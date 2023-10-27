package org.example.Controller;

import org.example.Model.ReservationModel;
import org.example.Room;
import org.example.View.ReservationView;

public class ReservationController {

    private ReservationView reservationView;
    private ReservationModel reservationModel;

    public ReservationController(ReservationView reservationView, ReservationModel reservationModel, Room room) {
        this.reservationView = reservationView;
        this.reservationModel = reservationModel;
    }

    public void startReservationProcess() {
        reservationView.displayWelcomeMessage();

        while (true) {
            reservationView.displayOptions();
            int choice = reservationView.getChoice();

            switch (choice) {
                case 1:
                    makeReservation();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    viewReservations();
                    break;
                case 4:
                    viewAvailableRooms();
                    break;
                case 5:
                    viewReservedRooms();
                    break;
                case 6:
                    reservationView.displayMessage("Exiting the Reservation System.");
                    return;
                default:
                    reservationView.displayMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void makeReservation() {
        String roomType = reservationView.getRoomType();
        String guestName = reservationView.getGuestName();
        reservationModel.makeReservation(roomType, guestName);
    }

    private void cancelReservation() {
        String roomNumber = reservationView.getRoomNumber();
        reservationModel.cancelReservation(roomNumber);
    }

    private void viewReservations() {
        reservationModel.viewReservations();
    }

    private void viewAvailableRooms() {
        reservationModel.viewAvailableRooms();
    }

    private void viewReservedRooms() {
        reservationModel.viewReservedRooms();
    }
}