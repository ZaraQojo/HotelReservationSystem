package org.example.Model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MainModel {

    private final String dataFilePath = "data.json";
    private Map<Integer, Boolean> roomAvailability;
    private Map<Integer, String> reservations;

    public MainModel() {
        roomAvailability = new HashMap<>();
        reservations = new HashMap<>();
    }

    public void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the JSON data and update the model
                Map<String, Object> data = parseJSONData(line);
                int roomNumber = (int) data.get("roomNumber");
                boolean isAvailable = (boolean) data.get("isAvailable");
                String guestName = (String) data.get("guestName");

                roomAvailability.put(roomNumber, isAvailable);
                if (guestName != null) {
                    reservations.put(roomNumber, guestName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveData() {
        try (FileWriter writer = new FileWriter(dataFilePath)) {
            for (Map.Entry<Integer, Boolean> entry : roomAvailability.entrySet()) {
                int roomNumber = entry.getKey();
                boolean isAvailable = entry.getValue();
                String guestName = null;

                if (reservations.containsKey(roomNumber)) {
                    guestName = reservations.get(roomNumber);
                }

                Map<String, Object> data = new HashMap<>();
                data.put("roomNumber", roomNumber);
                data.put("isAvailable", isAvailable);
                data.put("guestName", guestName);

                String jsonData = convertMapToJSONString(data);
                writer.write(jsonData + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isRoomAvailable(int roomNumber) {
        return roomAvailability.getOrDefault(roomNumber, true);
    }

    public void bookRoom(int roomNumber) {
        roomAvailability.put(roomNumber, false);
    }

    public void cancelReservation(int reservationId) {
        roomAvailability.put(reservationId, true);
        reservations.remove(reservationId);
    }

    public String getReservations() {
        StringBuilder reservationsString = new StringBuilder();

        for (Map.Entry<Integer, String> entry : reservations.entrySet()) {
            int roomNumber = entry.getKey();
            String guestName = entry.getValue();

            reservationsString.append("Room ").append(roomNumber).append(": ").append(guestName).append("\n");
        }

        return reservationsString.toString();
    }

    private Map<String, Object> parseJSONData(String jsonString) {
        // Implement JSON parsing logic to extract room number, availability, and guest name
        try {
            Map<String, Object> data = new HashMap<>();
            for (String line : jsonString.split("\n")) {
                String[] keyValue = line.split(":");
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();

                if (key.equalsIgnoreCase("roomNumber")) {
                    data.put("roomNumber", Integer.parseInt(value));
                } else if (key.equalsIgnoreCase("isAvailable")) {
                    data.put("isAvailable", Boolean.parseBoolean(value));
                } else if (key.equalsIgnoreCase("guestName")) {
                    data.put("guestName", value);
                }
            }

            return data;
        } catch (NumberFormatException e) {
            System.err.println("Invalid JSON data: " + jsonString);
            return null;
        }
    }

    private String convertMapToJSONString(Map<String, Object> data) {
        // Implement JSON serialization logic to convert the map to a JSON string
        StringBuilder jsonDataBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            jsonDataBuilder.append(key).append(": ").append(value).append("\n");
        }

        return jsonDataBuilder.toString();
    }


}
