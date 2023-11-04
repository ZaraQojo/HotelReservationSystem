package org.example.Model;

import org.example.User;

import java.io.*;

import java.util.*;

public class LoginModel {

    private List<User> users;
    private static final String DATA_FILE_PATH = "src/main/java/org/example/Model/userdata.json";

    public LoginModel() throws IOException {
        this.users = new ArrayList<>();
        loadDataFromFile();
    }


    private void loadDataFromFile() throws IOException {
        List<User> users = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_PATH));
        StringBuilder jsonString = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            jsonString.append(line);
        }

        StringTokenizer tokenizer = new StringTokenizer(jsonString.toString(), "{},[]:\"", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();

            if (token.equals("{")) {
                User user = new User();

                while (tokenizer.hasMoreTokens()) {
                    String key = tokenizer.nextToken().trim();
                    String value = tokenizer.nextToken().trim();

                    switch (key) {
                        case "username" -> user.setUsername(value);
                        case "password" -> user.setPassword(value);
                        case "role" -> user.setRole(value);
                    }

                    if (tokenizer.nextToken().equals("}")) {
                        users.add(user);
                        break;
                    }
                }
            }
        }
        reader.close();
    }


    private void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE_PATH))) {
            for (User user : users) {
                writer.write(user.getUsername() + "," + user.getPassword() + "," + user.getRole());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user.getRole();
            }
        }
        return null;
    }

    public void addUser(String username, String password, String role) {
        User newUser = new User(username, password, role);
        users.add(newUser);
        saveDataToFile();
    }
}
//LoginModel