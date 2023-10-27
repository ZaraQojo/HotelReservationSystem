package org.example.Controller;

import org.example.Model.AdminModel;
import org.example.View.AdminView;

public class AdminController {

    private AdminView adminView;
    private AdminModel adminModel;

    public AdminController(AdminView adminView, AdminModel adminModel) {
        this.adminView = adminView;
        this.adminModel = adminModel;
    }

    public void startAdminProcess() {
        adminView.displayWelcomeMessage();

        while (true) {
            adminView.displayOptions();
            int choice = adminView.getChoice();

            switch (choice) {
                case 1:
                    addStaffAccount();
                    break;
                case 2:
                    adminModel.viewAllStaffAccounts();
                    break;
                case 3:
                    adminModel.viewAllGuestAccounts();
                    break;
                case 4:
                    deleteStaffAccount();
                    break;
                case 5:
                    deleteGuestAccount();
                    break;
                case 6:
                    adminView.displayMessage("Exiting the Admin feature.");
                    return;
                default:
                    adminView.displayMessage("Invalid choice. Please try again.");
            }
        }
    }

    private void addStaffAccount() {
        String username = adminView.getUsername();
        String role = adminView.getRole();
        adminModel.addAccount(username, role);
    }

    private void deleteStaffAccount() {
        String username = adminView.getUsername();
        adminModel.deleteStaffAccount(username);
    }

    private void deleteGuestAccount() {
        String username = adminView.getUsername();
        adminModel.deleteGuestAccount(username);
    }
}