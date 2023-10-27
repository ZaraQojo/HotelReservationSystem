package org.example.Model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AdminModel {

    private Map<String, String> staffAccounts;
    private Map<String, String> guestAccounts;
    private static final String STAFF_FILE_PATH = "staffaccounts.json";
    private static final String GUEST_FILE_PATH = "guestaccounts.json";

    public AdminModel() {
        this.staffAccounts = new HashMap<>();
        this.guestAccounts = new HashMap<>();
        loadAccountsFromFile(STAFF_FILE_PATH, staffAccounts);
        loadAccountsFromFile(GUEST_FILE_PATH, guestAccounts);
    }

    private void loadAccountsFromFile(String filePath, Map<String, String> accounts) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String username = parts[0].trim();
                    String role = parts[1].trim();
                    accounts.put(username, role);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAccountToFile(String filePath, String username, String role) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(username + "," + role);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAccount(String username, String role) {
        if (role.equals("Receptionist") || role.equals("Admin")) {
            if (!staffAccounts.containsKey(username)) {
                staffAccounts.put(username, role);
                saveAccountToFile(STAFF_FILE_PATH, username, role);
                System.out.println(role + " account added: " + username);
            } else {
                System.out.println(role + " account with username " + username + " already exists.");
            }
        } else {
            System.out.println("Invalid role. Only Receptionist and Admin accounts can be created by an admin.");
        }
    }

    public void viewAllStaffAccounts() {
        System.out.println("All Staff Accounts:");
        for (Map.Entry<String, String> entry : staffAccounts.entrySet()) {
            System.out.println("Username: " + entry.getKey() + ", Role: " + entry.getValue());
        }
    }

    public void viewAllGuestAccounts() {
        System.out.println("All Guest Accounts:");
        for (Map.Entry<String, String> entry : guestAccounts.entrySet()) {
            System.out.println("Username: " + entry.getKey() + ", Role: " + entry.getValue());
        }
    }

    public void deleteStaffAccount(String username) {
        if (staffAccounts.containsKey(username)) {
            staffAccounts.remove(username);
            saveAccountsToFile(STAFF_FILE_PATH, staffAccounts);
            System.out.println("Staff account deleted: " + username);
        } else {
            System.out.println("Staff account with username " + username + " not found.");
        }
    }

    public void deleteGuestAccount(String username) {
        if (guestAccounts.containsKey(username)) {
            guestAccounts.remove(username);
            saveAccountsToFile(GUEST_FILE_PATH, guestAccounts);
            System.out.println("Guest account deleted: " + username);
        } else {
            System.out.println("Guest account with username " + username + " not found.");
        }
    }

    private void saveAccountsToFile(String filePath, Map<String, String> accounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : accounts.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}