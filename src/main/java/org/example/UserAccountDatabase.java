package org.example;
// TODO: Import JAR and add Try-Catch and Convert Data from Map to JSON

import java.util.*;

public class UserAccountDatabase {

    static Map<String, String> userAccounts;

    public UserAccountDatabase() {
        userAccounts = new HashMap<>();
    }

    public boolean accountExists(String username) {
        return userAccounts.containsKey(username);
    }

    public static void addNewAccount(String username, String password) {
        userAccounts.put(username, password);
    }

    public void deleteAccount(String username) {
        userAccounts.remove(username);
    }

    public String getPassword(String username) {
        return userAccounts.get(username);
    }
}
