package org.example;


public class Guest extends User {
    public Guest(String userName, String password) {
        super(userName, password);
    }

    public void GuestReservation() {

        Reservation res = new Reservation();
        res.reservation();

    }


}