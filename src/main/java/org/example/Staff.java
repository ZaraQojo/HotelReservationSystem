package org.example;

public class Staff extends User {

    public Staff(String userName, String password, String name) {
        super(userName, password);
    }

    static void checkGuestIn() {
    }

    static void checkGuestOut() {
        // set a room number to available and change guest details to make him as leave
    }

    static void makeReservation() {
        // add a reservation as a username and id and room number and arrival date and departure date

    }

    static void processPayment() {
        // adding a payment method (maybe FastPay API)
    }

    static void viewAndUpdate() {
        // it gets the guest ID and returns reservation information
    }


}
