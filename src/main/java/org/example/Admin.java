package org.example;

import java.util.*;

public class Admin {


    public static void addNewStaffAccount(String username, String password) {
        if (!username.startsWith("SS")) {
            throw new IllegalArgumentException("Staff account usernames must start with the prefix 'SS'");
        }

        UserAccountDatabase.addNewAccount(username, password);
    }

    public static List<String> viewAllStaffAccounts() {
        List<String> staffAccounts = new ArrayList<>();

        for (String username : UserAccountDatabase.userAccounts.keySet()) {
            if (username.startsWith("SS")) {
                staffAccounts.add(username);
            }
        }

        return staffAccounts;
    }

    public static List<String> viewAllGuestAccounts() {
        List<String> guestAccounts = new ArrayList<>();

        for (String username : UserAccountDatabase.userAccounts.keySet()) {
            if (!username.startsWith("SS")) {
                guestAccounts.add(username);
            }
        }

        return guestAccounts;
    }
}
