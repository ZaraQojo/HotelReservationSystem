package org.example;

import java.util.HashMap;
import java.util.Map;

public class Room {

    private Map<String, Integer> roomTypes; // Map room type to available room numbers
    private Map<Integer, Boolean> availableRooms; // Map room number to availability

    public Room() {
        this.roomTypes = new HashMap<>();
        initializeRoomTypes();
        this.availableRooms = new HashMap<>();
        initializeAvailableRooms();
    }

    private void initializeRoomTypes() {
        roomTypes.put("Single", 1);
        roomTypes.put("Double", 41);
        roomTypes.put("Deluxe", 61);
        roomTypes.put("VIP", 71);
    }

    private void initializeAvailableRooms() {
        for (int i = 1; i <= 40; i++) {
            availableRooms.put(i, true);
        }
        for (int i = 41; i <= 60; i++) {
            availableRooms.put(i, true);
        }
        for (int i = 61; i <= 70; i++) {
            availableRooms.put(i, true);
        }
        for (int i = 71; i <= 75; i++) {
            availableRooms.put(i, true);
        }
    }

    public int getAvailableRoomNumber(String roomType) {
        if (roomTypes.containsKey(roomType)) {
            int startNumber = roomTypes.get(roomType);
            for (int i = startNumber; i < startNumber + 10; i++) {
                if (availableRooms.containsKey(i) && availableRooms.get(i)) {
                    availableRooms.put(i, false); // Mark the room as reserved
                    return i;
                }
            }
        }
        return -1; // No available room for the given type
    }

    public void markRoomAsReserved(int roomNumber) {
        if (availableRooms.containsKey(roomNumber)) {
            availableRooms.put(roomNumber, false); // Mark the room as reserved
        }
    }

    public void markRoomAsAvailable(int roomNumber) {
        if (availableRooms.containsKey(roomNumber)) {
            availableRooms.put(roomNumber, true); // Mark the room as available
        }
    }

    public Map<Integer, Boolean> getAvailableRooms() {
        return availableRooms;
    }


}