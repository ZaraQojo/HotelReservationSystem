package org.example.Model;

import org.example.Room;

import java.io.*;
import java.util.*;

public class ReservationModel {

    private List<Reservation> reservations;
    private Room room;
    private static final String RESERVATION_FILE_PATH = "reservations.json";

    public ReservationModel(Room room) {
        this.reservations = new ArrayList<>();
        this.room = room;
        loadReservationsFromFile();
    }

    public ReservationModel(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public ReservationModel() {
    }

    private void loadReservationsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(RESERVATION_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int roomNumber = Integer.parseInt(parts[0]);
                    String guestName = parts[1];
                    Date checkInDate = new Date(parts[2]);
                    Date checkOutDate = new Date(parts[3]);
                    reservations.add(new Reservation(roomNumber, guestName, checkInDate, checkOutDate));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveReservationsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RESERVATION_FILE_PATH))) {
            for (Reservation reservation : reservations) {
                writer.write(reservation.getRoomNumber() + "," + reservation.getGuestName() + "," + reservation.getCheckInDate() + "," + reservation.getCheckOutDate());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void makeReservation(String roomType, String guestName) {
        int roomNumber = room.getAvailableRoomNumber(roomType);
        if (roomNumber != -1) {
            reservations.add(new Reservation(roomNumber, guestName));
            saveReservationsToFile();
            System.out.println("Reservation for " + guestName + " in Room " + roomNumber + " is confirmed.");
        } else {
            System.out.println("Sorry, no available room for the selected type.");
        }
    }

    public void cancelReservation(String roomNumber) {
        if (reservations.stream().anyMatch(reservation -> reservation.getRoomNumber() == Integer.parseInt(roomNumber))) {
            reservations.removeIf(reservation -> reservation.getRoomNumber() == Integer.parseInt(roomNumber));
            room.markRoomAsAvailable(Integer.parseInt(roomNumber));
            saveReservationsToFile();
            System.out.println("Reservation for Room " + roomNumber + " is canceled.");
        } else {
            System.out.println("No reservation found for Room " + roomNumber);
        }
    }

    public void viewReservations() {
        System.out.println("All Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
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
    }

    public List<Reservation> getReservations() {
        return Collections.unmodifiableList(reservations);
    }

    public Reservation getReservationByGuestName(String guestName) {
        return reservations.stream().filter(reservation -> reservation.getGuestName().equals(guestName)).findFirst().orElse(null);
    }

    public void updateReservation(Reservation reservation) {
        int roomNumber = reservation.getRoomNumber();
        if (reservations.stream().anyMatch(r -> r.getRoomNumber() == roomNumber)) {
            reservations.removeIf(r -> r.getRoomNumber() == roomNumber);
            reservations.add(reservation);
            saveReservationsToFile();
            System.out.println("Reservation for Room " + roomNumber + " is updated.");
        } else {
            System.out.println("No reservation found for Room " + roomNumber);
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
