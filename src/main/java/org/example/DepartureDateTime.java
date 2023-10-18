package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class DepartureDateTime {

    public static LocalDate getDepartureDate() {
        // Get the current date
        LocalDate today = LocalDate.now();

        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the departure date
        System.out.print("Enter the departure date (YYYY-MM-DD): ");

        // Read the departure date from the console
        String departureDateStr = scanner.nextLine();

        // Parse the departure date string into a LocalDate object
        LocalDate departureDate = LocalDate.parse(departureDateStr);



        // Return the departure date
        return departureDate;
    }

    public static LocalTime getDepartureTime() {
        // Get the current time
        LocalTime now = LocalTime.now();

        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the departure time
        System.out.print("Enter the departure time (HH:MM): ");

        // Read the departure time from the console
        String departureTimeStr = scanner.nextLine();

        // Parse the departure time string into a LocalTime object
        LocalTime departureTime = LocalTime.parse(departureTimeStr);


        // Return the departure time
        return departureTime;
    }
}