package org.example.Controller;

import org.example.Model.ReceptionistModel;
import org.example.Model.ReservationModel;
import org.example.User;
import org.example.View.ReceptionistView;

public class ReceptionistController {

    private ReceptionistView receptionistView;
    private ReceptionistModel receptionistModel;

    public ReceptionistController(ReceptionistView receptionistView, ReceptionistModel receptionistModel) {
        this.receptionistView = receptionistView;
        this.receptionistModel = receptionistModel;
    }

    public ReceptionistController(ReceptionistView receptionistView, ReceptionistModel receptionistModel, ReservationModel reservationModel) {
    }

    public void startReceptionistProcess() {
        receptionistView.displayWelcomeMessage();

        while (true) {
            receptionistView.displayOptions();
            int choice = receptionistView.getChoice();

            switch (choice) {
                case 1:
                    checkInGuest();
                    break;
                case 2:
                    checkOutGuest();
                    break;
                case 3:
                    makeReservation();
                    break;
                case 4:
                    cancelReservation();
                    break;
                case 5:
                    receptionistView.displayMessage("Exiting the Receptionist System.");
                    return;
                default:
                    receptionistView.displayMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void checkInGuest() {
        String roomType = receptionistView.getRoomType();
        String guestName = receptionistView.getGuestName();
        receptionistModel.checkInGuest(roomType, guestName);
    }

    private void checkOutGuest() {
        String roomNumber = receptionistView.getRoomNumber();
        receptionistModel.checkOutGuest(roomNumber);
    }

    private void makeReservation() {
        String roomType = receptionistView.getRoomType();
        String guestName = receptionistView.getGuestName();
        receptionistModel.makeReservation(roomType, guestName);
    }

    private void cancelReservation() {
        String roomNumber = receptionistView.getRoomNumber();
        receptionistModel.cancelReservation(roomNumber);
    }

    public void startReceptionistProcess(User currentUser) {
    }
}