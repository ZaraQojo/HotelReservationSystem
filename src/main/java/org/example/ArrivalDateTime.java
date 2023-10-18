package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ArrivalDateTime {

    public static LocalDate getArrivalDate() {
        // Get the current date
        LocalDate today = LocalDate.now();

        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the arrival date
        System.out.println("Enter the arrival date (YYYY-MM-DD): ");

        // Read the arrival date from the console
        String arrivalDateStr = scanner.nextLine();

        // Parse the arrival date string into a LocalDate object
        LocalDate arrivalDate = LocalDate.parse(arrivalDateStr);


        // Return the arrival date
        return arrivalDate;
    }

    public static LocalTime getArrivalTime() {
        // Get the current time
        LocalTime now = LocalTime.now();

        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the arrival time
        System.out.println("Enter the arrival time (HH:MM): ");

        // Read the arrival time from the console
        String arrivalTimeStr = scanner.nextLine();

        // Parse the arrival time string into a LocalTime object
        LocalTime arrivalTime = LocalTime.parse(arrivalTimeStr);

        // Return the arrival time
        return arrivalTime;
    }
}