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

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final int LOGIN_STATE = 1;
    private static final int GUEST_STATE = 2;
    private static final int RECEPTIONIST_STATE = 3;
    private static final int EXIT_STATE = 4;

    public static void main(String[] args) throws IOException {
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
        // Start the program
        int currentState = LOGIN_STATE;
        User currentUser = null;

        while (true) {
            //    currentUser = loginController.startLoginProcess();
            System.out.println("Login failed. Please try again.");
            continue;

        }
    }
}