package org.example.Model;

import org.example.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SignUpModel {

    private List<User> users;
    private static final String DATA_FILE_PATH = "userdata.json";

    public SignUpModel() {
        this.users = new ArrayList<>();
        loadDataFromFile();
    }

    private void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    String role = parts[2].trim();
                    users.add(new User(username, password, role));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE_PATH, true))) {
            User newUser = users.get(users.size() - 1);
            writer.write(newUser.getUsername() + "," + newUser.getPassword() + "," + newUser.getRole());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isUserExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void addGuestUser(String username, String password) {
        addUser(username, password, "Guest");
    }

    public void addUser(String username, String password, String role) {
        if (!isUserExists(username)) {
            User newUser = new User(username, password, role);
            users.add(newUser);
            saveDataToFile();
        }
    }
}