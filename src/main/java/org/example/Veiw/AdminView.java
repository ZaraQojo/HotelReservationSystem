package org.example;

import java.util.*;

public class AdminView {
    static Scanner sc =  new Scanner(System.in);

    public static void showAdminView() {
        // Display the admin view menu
        System.out.println("Admin View Menu:");
        System.out.println("1. Add new staff account");
        System.out.println("2. View all staff accounts");
        System.out.println("3. View all guest accounts");
        System.out.println("4. Exit");

        // Get the user's selection
        int selection = sc.nextInt();

        // Keep the admin view running until the user enters 4
        do {
            // Call the appropriate method based on the user's selection
            switch (selection) {
                case 1:
                    addNewStaffAccount();
                    break;
                case 2:
                    viewAllStaffAccounts();
                    break;
                case 3:
                    viewAllGuestAccounts();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid selection");
            }

            // Display the admin view menu again
            System.out.println("Admin View Menu:");
            System.out.println("1. Add new staff account");
            System.out.println("2. View all staff accounts");
            System.out.println("3. View all guest accounts");
            System.out.println("4. Exit");

            // Get the user's selection again
            selection = sc.nextInt();
        } while (selection != 4);
    }

    private static void addNewStaffAccount() {
        // Get the username and password from the user
        System.out.println("Enter username: ");
        String username = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();

        // Add the new staff account
        Admin.addNewStaffAccount(username, password);

        // Display a success message
        System.out.println("New staff account created successfully!");
    }

    private static void viewAllStaffAccounts() {
        // Get the list of all staff accounts
        List<String> staffAccounts = Admin.viewAllStaffAccounts();

        // If the staff accounts list is null, display a message saying "No staff accounts yet"
        // Display the list of staff accounts to the user
        System.out.println("List of all staff accounts:");
        for (String staffAccount : staffAccounts) {
            System.out.println(staffAccount);
        }
    }

    private static void viewAllGuestAccounts() {
        // Get the list of all guest accounts
        List<String> guestAccounts = Admin.viewAllGuestAccounts();

        // If the guest accounts list is null, display a message saying "No guest accounts yet"
        // Display the list of guest accounts to the user
        System.out.println("List of all guest accounts:");
        for (String guestAccount : guestAccounts) {
            System.out.println(guestAccount);
        }
    }
}
