package org.example;

import java.util.Scanner;

public class GuestView {
    Scanner sc = new Scanner(System.in);
    private Guest guest;



    public void showGuestView() {
        // Display the guest view menu
        System.out.println("Guest View Menu:");
        System.out.println("1. Make a reservation");
        System.out.println("2. View and manage reservations");
        System.out.println("3. Check in");
        System.out.println("4. Check out");
        System.out.println("5. Exit");

        // Get the user's selection
        int selection = sc.nextInt();

        // Call the appropriate method based on the user's selection
        switch (selection) {
            case 1:
                guest.GuestReservation();
                break;
            case 2:
                // View and manage reservations
                break;
            case 3:
                // Check in
                break;
            case 4:
                // Check out
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid selection");
        }
    }
}
