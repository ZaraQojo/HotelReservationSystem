package org.example.Model;

import org.example.Room;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReceptionistModel {

    private Map<String, String> checkedInGuests;
    private Room room;
    private static final String CHECKED_IN_FILE_PATH = "checkin.json";

    public ReceptionistModel(Room room) {
        this.checkedInGuests = new HashMap<>();
        this.room = room;
        loadCheckedInGuestsFromFile();
    }

    private void loadCheckedInGuestsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CHECKED_IN_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String roomNumber = parts[0].trim();
                    String guestName = parts[1].trim();
                    checkedInGuests.put(roomNumber, guestName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveCheckedInGuestsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CHECKED_IN_FILE_PATH))) {
            for (Map.Entry<String, String> entry : checkedInGuests.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkInGuest(String roomType, String guestName) {
        int roomNumber = room.getAvailableRoomNumber(roomType);
        if (roomNumber != -1) {
            checkedInGuests.put(String.valueOf(roomNumber), guestName);
            saveCheckedInGuestsToFile();
            System.out.println("Guest " + guestName + " checked in to Room " + roomNumber + ".");
        } else {
            System.out.println("Sorry, no available room for the selected type.");
        }
    }

    public void checkOutGuest(String roomNumber) {
        if (checkedInGuests.containsKey(roomNumber)) {
            String guestName = checkedInGuests.remove(roomNumber);
            room.markRoomAsAvailable(Integer.parseInt(roomNumber));
            saveCheckedInGuestsToFile();
            System.out.println("Guest " + guestName + " checked out from Room " + roomNumber + ".");
        } else {
            System.out.println("No checked-in guest found for Room " + roomNumber);
        }
    }

    public void makeReservation(String roomType, String guestName) {
        int roomNumber = room.getAvailableRoomNumber(roomType);
        if (roomNumber != -1) {
            checkedInGuests.put(String.valueOf(roomNumber), guestName);
            saveCheckedInGuestsToFile();
            System.out.println("Reservation for " + guestName + " in Room " + roomNumber + " is confirmed.");
        } else {
            System.out.println("Sorry, no available room for the selected type.");
        }
    }

    public void cancelReservation(String roomNumber) {
        if (checkedInGuests.containsKey(roomNumber)) {
            checkedInGuests.remove(roomNumber);
            room.markRoomAsAvailable(Integer.parseInt(roomNumber));
            saveCheckedInGuestsToFile();
            System.out.println("Reservation for Room " + roomNumber + " is canceled.");
        } else {
            System.out.println("No reservation found for Room " + roomNumber);
        }
    }
}