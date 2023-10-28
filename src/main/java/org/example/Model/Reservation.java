package org.example.Model;

import java.util.*;

public class Reservation {
    private int id;
    private int roomNumber;
    private String guestName;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(int id, int roomNumber, String guestName, Date checkInDate, Date checkOutDate) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Reservation() {

    }
    public Reservation(int roomNumber, String guestName, Date checkInDate, Date checkOutDate) {
    }

    public Reservation(int roomNumber, String guestName) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", guestName='" + guestName + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
}
