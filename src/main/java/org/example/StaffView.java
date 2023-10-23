package org.example;

import java.util.Scanner;

public class StaffView {

    static Scanner sc = new Scanner(System.in);

    public static void showStaffView() {
        // Display the staff view menu
        System.out.println("Staff View Menu:\n");
        System.out.println("1. Check guest in");
        System.out.println("2. Check guest out");
        System.out.println("3. Make reservation");
        System.out.println("4. Process payment");
        System.out.println("5. View and update reservation");
        System.out.println("6. Exit\n");

        // Get the user's selection
        int selection = sc.nextInt();

        // Call the appropriate method based on the user's selection
        if (selection == 1) {
            Staff.checkGuestIn();
        } else if (selection == 2) {
            Staff.checkGuestOut();
        } else if (selection == 3) {
            Staff.makeReservation();
        } else if (selection == 4) {
            Staff.processPayment();
        } else if (selection == 5) {
            Staff.viewAndUpdate();
        } else if (selection == 6) {
            System.exit(0);
        } else {
            System.out.println("Invalid selection");
        }
    }
}
