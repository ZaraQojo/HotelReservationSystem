package org.example;

import java.util.Scanner;

public class GuestView extends Reservation {
    Scanner sc = new Scanner(System.in);
    private Guest guest;



    public void showGuestView() {
        // Display the guest view menu
        System.out.println("Guest View Menu:");
        System.out.println("1. Make a reservation");
        System.out.println("2. View and manage reservations");
        System.out.println("3. Exit");

        // Get the user's selection
        int selection = sc.nextInt();

        // Call the appropriate method based on the user's selection
        switch (selection) {
            case 1:
                guest.GuestReservation();
                break;
            case 2:
                // View and manage reservations
                System.out.println("Do you want to View Reservation or Mange Reservation");
                System.out.println("To view Reservation, choose 1");
                System.out.println("To manage Reservation, choose 2");
                int option=sc.nextInt();
                if(option==1){
                    guest.viewReservation();

                } else if (option==2) {
                    guest.ManageReservation();
                }
                else {
                    System.out.println("Invalid Input");
                }
                break;

            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid selection");
        }
    }
}