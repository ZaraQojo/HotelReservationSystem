package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Reservation {
    public void reservation(){
        int choice;
        Scanner choices=new Scanner(System.in);
        do {
            System.out.println("Choose an option to continue with the reservation system");
            System.out.println("1: Choose Room Type");
            System.out.println("2:Choose The Arrival Date and Time");
            System.out.println("3:Choose The Departure Date and Time");
            System.out.println("0. Choose 0 to exit");
            choice=choices.nextInt();
            if(choice==1){
                RoomType();
            } else if (choice==2) {
                LocalDate arrivalDate = ArrivalDateTime.getArrivalDate();
                LocalTime arrivalTime = ArrivalDateTime.getArrivalTime();
            } else if (choice==3) {
                LocalDate departureDate = DepartureDateTime.getDepartureDate();
                LocalTime departureTime = DepartureDateTime.getDepartureTime();

            }
        }while (choice!=0);


    }
    public void RoomType(){
        String roomchoice = null;
        Scanner room=new Scanner(System.in);
        System.out.println("Choose the room type:");
        System.out.println("A.Single Room. Price is $80");
        System.out.println("B.Double Room. Price is $100");
        System.out.println("C.VIP Room. Price is $150");
        System.out.println("D.Deluxe Room. Price is $120");
        roomchoice=room.next();
        switch (roomchoice){
            case "A","a":
                System.out.println("You chose Single Room Type.");
                System.out.println("THANK YOU!!!");
                break;
            case "B","b":
                System.out.println("You chose Double Room Type.");
                System.out.println("THANK YOU!!!");
                break;
            case "C","c":
                System.out.println("You chose VIP Room Type.");
                System.out.println("THANK YOU!!!");
                break;
            case "D","d":
                System.out.println("You chose Deluxe Room Type.");
                System.out.println("THANK YOU!!!");
                break;
            default:
                System.out.println("Invalid Option");
        }
    }
}