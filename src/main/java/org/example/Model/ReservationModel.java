package org.example.Model;

import org.example.Room;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReservationModel {

    private Map<String, String> reservations;
    private Room room;
    private static final String RESERVATION_FILE_PATH = "reservations.json";

    public ReservationModel(Room room) {
        this.reservations = new HashMap<>();
        this.room = room;
        loadReservationsFromFile();
    }

    private void loadReservationsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(RESERVATION_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String roomNumber = parts[0].trim();
                    String guestName = parts[1].trim();
                    reservations.put(roomNumber, guestName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveReservationToFile(String roomNumber, String guestName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RESERVATION_FILE_PATH, true))) {
            writer.write(roomNumber + "," + guestName);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveReservationsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RESERVATION_FILE_PATH))) {
            for (Map.Entry<String, String> entry : reservations.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeReservation(String roomType, String guestName) {
        int roomNumber = room.getAvailableRoomNumber(roomType);
        if (roomNumber != -1) {
            reservations.put(String.valueOf(roomNumber), guestName);
            saveReservationToFile(String.valueOf(roomNumber), guestName);
            System.out.println("Reservation for " + guestName + " in Room " + roomNumber + " is confirmed.");
        } else {
            System.out.println("Sorry, no available room for the selected type.");
        }
    }

    public void cancelReservation(String roomNumber) {
        if (reservations.containsKey(roomNumber)) {
            reservations.remove(roomNumber);
            room.markRoomAsAvailable(Integer.parseInt(roomNumber));
            saveReservationsToFile();
            System.out.println("Reservation for Room " + roomNumber + " is canceled.");
        } else {
            System.out.println("No reservation found for Room " + roomNumber);
        }
    }

    public void viewReservations() {
        System.out.println("All Reservations:");
        for (Map.Entry<String, String> entry : reservations.entrySet()) {
            System.out.println("Room: " + entry.getKey() + ", Guest: " + entry.getValue());
        }
    }

    public void viewAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Map.Entry<Integer, Boolean> entry : room.getAvailableRooms().entrySet()) {
            System.out.println("Room: " + entry.getKey() + ", Type: " + getRoomType(String.valueOf(entry.getKey())));
        }
    }

    public void viewReservedRooms() {
        System.out.println("Reserved Rooms:");
        for (Map.Entry<String, String> entry : reservations.entrySet()) {
            System.out.println("Room: " + entry.getKey() + ", Guest: " + entry.getValue());
        }
    }

    private String getRoomType(String roomNumber) {
        int roomNum = Integer.parseInt(roomNumber);
        if (roomNum >= 1 && roomNum <= 40) {
            return "Single";
        } else if (roomNum >= 41 && roomNum <= 60) {
            return "Double";
        } else if (roomNum >= 61 && roomNum <= 70) {
            return "Deluxe";
        } else if (roomNum >= 71 && roomNum <= 75) {
            return "VIP";
        } else {
            return "Unknown";
        }
    }
}