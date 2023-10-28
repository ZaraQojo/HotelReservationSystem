package org.example.services;

import org.example.Model.Reservation;
import org.example.Model.ReservationModel;

import java.io.*;
import java.util.*;

public class ReservationService {

    private File reservationsFile;

    public ReservationService() {
        this.reservationsFile = new File("reservations.json");
        if (!reservationsFile.exists()) {
            try {
                reservationsFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Reservation> getReservations() throws IOException {
        List<Reservation> reservations = new ArrayList<>();

        // Read the reservations from the JSON file.
        try (FileReader fileReader = new FileReader(reservationsFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Reservation reservation = new Reservation();
                reservation.setId(Integer.parseInt(line.split(",")[0]));
                reservation.setRoomNumber(Integer.parseInt(line.split(",")[1]));
                reservation.setGuestName(line.split(",")[2]);
                reservation.setCheckInDate(new Date(line.split(",")[3]));
                reservation.setCheckOutDate(new Date(line.split(",")[4]));
                reservations.add(reservation);
            }
        }

        return reservations;
    }

    public Reservation getReservationById(int reservationId) throws IOException {
        for (Reservation reservation : getReservations()) {
            if (reservation.getId() == reservationId) {
                return reservation;
            }
        }
        return null;
    }

    public void createReservation(Reservation reservation) throws IOException {
        // Write the reservation to the JSON file.
        try (FileWriter fileWriter = new FileWriter(reservationsFile, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(reservation.getId() + "," + reservation.getRoomNumber() + "," + reservation.getGuestName() + "," + reservation.getCheckInDate().getTime() + "," + reservation.getCheckOutDate().getTime() + "\n");
        }
    }

    public void updateReservation(Reservation reservation) throws IOException {
        // Delete the existing reservation from the JSON file.
        for (int i = 0; i < getReservations().size(); i++) {
            if (getReservations().get(i).getId() == reservation.getId()) {
                getReservations().remove(i);
                break;
            }
        }

        // Write the updated reservation to the JSON file.
        createReservation(reservation);
    }

    public void cancelReservation(int reservationId) throws IOException {
        // Delete the reservation from the JSON file.
        for (int i = 0; i < getReservations().size(); i++) {
            if (getReservations().get(i).getId() == reservationId) {
                getReservations().remove(i);
                break;
            }
        }
    }
}
