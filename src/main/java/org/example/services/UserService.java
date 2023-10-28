package org.example.services;
import org.example.User;

import java.io.*;
import java.util.*;

public class UserService {

    private static final String USER_DATA_FILE = "userdata.json";

    public static User authenticateUser(String username, String password) throws IOException {
        // Read the user data from the JSON file.
        String userJson = readFile(USER_DATA_FILE);

        // Parse the JSON string to a list of users.
        List<User> users = parseJson(userJson);

        // Find the user with the given username and password.
        User user = users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst().orElse(null);

        // Return the user object if the login is successful, or null if the login is unsuccessful.
        return user;
    }

    public static void createUser(User user) throws IOException {
        // Read the user data from the JSON file.
        String userJson = readFile(USER_DATA_FILE);

        // Parse the JSON string to a list of users.
        List<User> users = parseJson(userJson);

        // Add the new user to the list of users.
        users.add(user);

        // Convert the list of users to a JSON string.
        String updatedUserJson = toJson(users);

        // Write the JSON string to the file.
        writeFile(USER_DATA_FILE, updatedUserJson);
    }

    private static String readFile(String filePath) throws IOException {
        // Create a file reader.
        FileReader fileReader = new FileReader(filePath);

        // Read the contents of the file into a string.
        StringBuilder stringBuilder = new StringBuilder();
        int c;
        while ((c = fileReader.read()) != -1) {
            stringBuilder.append((char) c);
        }

        // Close the file reader.
        fileReader.close();

        // Return the contents of the file as a string.
        return stringBuilder.toString();
    }

    private static void writeFile(String filePath, String contents) throws IOException {
        // Create a file writer.
        FileWriter fileWriter = new FileWriter(filePath);

        // Write the contents of the string to the file.
        fileWriter.write(contents);

        // Close the file writer.
        fileWriter.close();
    }

    private static List<User> parseJson(String json) {
        // Create a list to store the users.
        List<User> users = new ArrayList<>();

        // Split the JSON string into an array of strings.
        String[] userObjects = json.split("}");

        // Iterate over the array of JSON strings and parse each string into a User object.
        for (String userObject : userObjects) {
            // Remove the curly braces from the JSON string.
            String trimmedUserObject = userObject.substring(1, userObject.length() - 1);

            // Split the JSON string into an array of key-value pairs.
            String[] keyValuePairs = trimmedUserObject.split(",");

            // Create a new User object.
            User user = new User();

            // Iterate over the key-value pairs and set the corresponding properties on the User object.
            for (String keyValuePair : keyValuePairs) {
                String[] keyValue = keyValuePair.split(":");
                String key = keyValue[0].trim();
                String value = keyValue[1].trim().replace("\"", "");

                switch (key) {
                    case "username":
                        user.setUsername(value);
                        break;
                    case "password":
                        user.setPassword(value);
                        break;
                }
            }

            // Add the User object to the list of users.
            users.add(user);
        }

        // Return the list of users.
        return users;
    }

    private static String toJson(List<User> users) {
        // Create a StringBuilder to store the JSON string.
        StringBuilder stringBuilder = new StringBuilder();

        // Start the JSON string with an opening curly brace.
        stringBuilder.append("{");

        // Iterate over the list of users and append each user object to the JSON string.
        for (User user : users) {
            stringBuilder.append("\"");
            stringBuilder.append(user.getUsername());
            stringBuilder.append("\": {");
            stringBuilder.append("\"username\": \"");
            stringBuilder.append(user.getUsername());
            stringBuilder.append("\", ");
            stringBuilder.append("\"password\": \"");
            stringBuilder.append(user.getPassword());
            stringBuilder.append("\"");
            stringBuilder.append("}");

            // If this is not the last user in the list, append a comma.
            if (user != users.get(users.size() - 1)) {
                stringBuilder.append(",");
            }
        }

        // Close the JSON string with a closing curly brace.
        stringBuilder.append("}");

        // Return the JSON string.
        return stringBuilder.toString();
    }
}
