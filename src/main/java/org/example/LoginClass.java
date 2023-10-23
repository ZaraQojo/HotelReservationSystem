package org.example;

import java.util.Scanner;

public class LoginClass {
    static Scanner sc = new Scanner(System.in);
    static String userName;
    static String pass;

    static void getData() {
        System.out.println("Please Enter the User Name");
        userName = sc.next();
        System.out.println("Please Enter the Password");
        pass = sc.next();
    }

    static boolean login() {

        UserAccountDatabase acc = new UserAccountDatabase();
        // Check if the username exists.
        if (!acc.accountExists(userName)) {
            return false;
        }
        Object square = null;

        // Check if the password is correct.
        String storedPassword = acc.getPassword(userName);
        if (!pass.equals(storedPassword)) {
            return false;
        }
        // The username and password are correct.
        return true;
    }

    static boolean staffAccount() {
        if (userName.charAt(0) == 'S' && userName.charAt(1) == 'S') {
            return true;
        } else
            return false;


    }
}




