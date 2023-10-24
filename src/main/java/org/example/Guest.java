package org.example;
// TODO: Import JAR and add Try-Catch

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Guest extends User {
    public Guest(String userName, String password) {

        super(userName, password);
    }

    Reservation res = new Reservation();

    public void GuestReservation() {
        res.reservation();
    }

    public void viewReservation() {
        res.viewReservation();
    }

    Scanner sc = new Scanner(System.in);

    public void ManageReservation() {
        System.out.println("What do you want to change?");
        System.out.println("1)Check in time and date");
        System.out.println("2)Check out time and date");
        System.out.println("3)Change all");
        int option = sc.nextInt();
        if (option == 1) {
            System.out.print("Enter a date (yyyy-MM-dd): ");
            String dateInput = sc.next();
            LocalDate localDate = LocalDate.parse(dateInput);
            System.out.print("Enter a time (HH:mm:ss): ");
            String timeInput = sc.next();
            LocalTime localTime = LocalTime.parse(timeInput);
            res.manageReservationCheckIn(localDate, localTime);
        } else if (option == 2) {
            System.out.print("Enter a date (yyyy-MM-dd): ");
            String dateInput = sc.next();
            LocalDate localDate = LocalDate.parse(dateInput);
            System.out.print("Enter a time (HH:mm:ss): ");
            String timeInput = sc.next();
            LocalTime localTime = LocalTime.parse(timeInput);
            res.manageReservationCheckOut(localDate, localTime);
        } else if (option == 3) {
            System.out.print("Enter a date (yyyy-MM-dd): ");
            String dateInputCheckIn = sc.next();
            LocalDate localDateCheckIn = LocalDate.parse(dateInputCheckIn);
            System.out.print("Enter a time (HH:mm:ss): ");
            String timeInputCheckIn = sc.next();
            LocalTime localTimeCheckIn = LocalTime.parse(timeInputCheckIn);
            System.out.print("Enter a date (yyyy-MM-dd): ");
            String dateInputCheckOut = sc.next();
            LocalDate localDateCheckOut = LocalDate.parse(dateInputCheckOut);
            System.out.print("Enter a time (HH:mm:ss): ");
            String timeInputCheckOut = sc.next();
            LocalTime localTimeCheckOut = LocalTime.parse(timeInputCheckOut);
            res.manageReservationall(localDateCheckIn, localTimeCheckIn, localDateCheckOut, localTimeCheckOut);
        } else {
            System.out.println("Ivalid Option");
        }
    }
}