package org.example.Model;

import org.example.Room;

import java.util.Map;

public class GuestModel {

    private Room room;

    public GuestModel(Room room) {

        this.room = room;
    }

    public String getAvailableRooms() {
        Map<Integer, Boolean> availableRooms = room.getAvailableRooms();
        StringBuilder roomsStringBuilder = new StringBuilder();

        for (Map.Entry<Integer, Boolean> entry : availableRooms.entrySet()) {
            if (entry.getValue()) {
                roomsStringBuilder.append("Room: ").append(entry.getKey()).append("\n");
            }
        }

        return roomsStringBuilder.toString();
    }

    public String getReservedRooms() {
        Map<Integer, Boolean> availableRooms = room.getAvailableRooms();
        StringBuilder roomsStringBuilder = new StringBuilder();

        for (Map.Entry<Integer, Boolean> entry : availableRooms.entrySet()) {
            if (!entry.getValue()) {
                roomsStringBuilder.append("Room: ").append(entry.getKey()).append("\n");
            }
        }

        return roomsStringBuilder.toString();
    }

    public void makeReservation(String roomType, String guestName) {
        int roomNumber = room.getAvailableRoomNumber(roomType);
        if (roomNumber != -1) {
            room.markRoomAsReserved(roomNumber);
            System.out.println("Reservation for " + guestName + " in Room " + roomNumber + " is confirmed.");
        } else {
            System.out.println("Sorry, no available room for the selected type.");
        }
    }
}