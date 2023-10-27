package org.example;

import org.example.Controller.GuestController;
import org.example.Controller.LoginController;
import org.example.Controller.ReceptionistController;
import org.example.Controller.ReservationController;
import org.example.Model.GuestModel;
import org.example.Model.ReceptionistModel;
import org.example.Model.ReservationModel;

import org.example.View.GuestView;
import org.example.View.LoginView;
import org.example.View.ReceptionistView;
import org.example.View.ReservationView;

import java.util.Scanner;

public class Main {

    private static final int LOGIN_STATE = 1;
    private static final int GUEST_STATE = 2;
    private static final int RECEPTIONIST_STATE = 3;
    private static final int EXIT_STATE = 4;

    public static void main(String[] args) {
        // Initialize models
        Room room = new Room();
        GuestModel guestModel = new GuestModel(room);
        ReceptionistModel receptionistModel = new ReceptionistModel(room);
        ReservationModel reservationModel = new ReservationModel(room);

        // Initialize views
        LoginView loginView = new LoginView();
        GuestView guestView = new GuestView();
        ReceptionistView receptionistView = new ReceptionistView();
        ReservationView reservationView = new ReservationView();

        // Initialize controllers
        LoginController loginController = new LoginController(loginView);
        GuestController guestController = new GuestController(guestView, guestModel);
        ReceptionistController receptionistController = new ReceptionistController(receptionistView, receptionistModel, reservationModel);
        ReservationController reservationController = new ReservationController(reservationView, reservationModel, room);

        // Start the program
        Scanner scanner = new Scanner(System.in);
        int currentState = LOGIN_STATE;
        User currentUser = null;

        while (currentState != EXIT_STATE) {
            switch (currentState) {
                case LOGIN_STATE:
                    currentUser = loginController.startLoginProcess();
                    if (currentUser == null) {
                        System.out.println("Login failed. Please try again.");
                        continue;
                    }

                    currentState = (currentUser.getRole().equals("Guest")) ? GUEST_STATE : RECEPTIONIST_STATE;
                    break;
                case GUEST_STATE:
                    guestController.startGuestProcess(currentUser);
                    currentState = LOGIN_STATE;
                    break;
                case RECEPTIONIST_STATE:
                    receptionistController.startReceptionistProcess(currentUser);
                    currentState = LOGIN_STATE;
                    break;
                default:
                    System.out.println("Invalid state. Exiting the Hotel Reservation System.");
                    System.exit(1);
            }
        }
        System.out.println("Exiting the Hotel Reservation System.");
    }
}