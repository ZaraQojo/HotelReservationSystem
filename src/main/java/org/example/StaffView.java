package org.example;

import java.util.Scanner;

public class StaffView {

    Scanner sc = new Scanner(System.in);
    private Staff staff;

    public StaffView(Staff staff) {
        this.staff = staff;
    }

    public void showStaffView() {
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
            staff.checkGuestIn();
        } else if (selection == 2) {
            staff.checkGuestOut();
        } else if (selection == 3) {
            staff.makeReservation();
        } else if (selection == 4) {
            staff.processPayment();
        } else if (selection == 5) {
            staff.viewAndUpdate();
        } else if (selection == 6) {
            System.exit(0);
        } else {
            System.out.println("Invalid selection");
        }
    }
}
