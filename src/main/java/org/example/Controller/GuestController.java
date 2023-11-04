package org.example.Controller;

import org.example.Model.GuestModel;
import org.example.User;
import org.example.View.GuestView;

public class GuestController {

    private GuestView guestView;
    private GuestModel guestModel;
//TODO: add router controller
    public GuestController(GuestView guestView, GuestModel guestModel) {
        this.guestView = guestView;
        this.guestModel = guestModel;
    }

    public void startGuestProcess() {
        guestView.displayWelcomeMessage();

        while (true) {
            guestView.displayOptions();
            int choice = guestView.getChoice();

            switch (choice) {
                case 1 -> viewAvailableRooms();
                case 2 -> makeReservation();
                case 3 -> viewReservedRooms();
                case 4 -> {
                    guestView.displayWelcomeMessage("Exiting the Guest System.");
                    return;
                }
                default -> guestView.displayWelcomeMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void viewAvailableRooms() {
        String availableRooms = guestModel.getAvailableRooms();
        guestView.displayAvailableRooms(availableRooms);
    }

    private void makeReservation() {
        String roomType = guestView.getRoomType();
        String guestName = "Guest"; // Assuming the guest making the reservation is the current guest
        guestModel.makeReservation(roomType, guestName);
    }

    private void viewReservedRooms() {
        String reservedRooms = guestModel.getReservedRooms();
        guestView.displayReservedRooms(reservedRooms);
    }

    public void startGuestProcess(User currentUser) {
    }
}