package org.example;

import java.util.Scanner;

public class SignUpClass {
    static Scanner sc = new Scanner(System.in);

    static UserAccountDatabase acc = new UserAccountDatabase();


    public static void signUp() {
        System.out.println("Enter username: ");
        String username = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();

        acc.addNewAccount(username, password);

        System.out.println("Account created successfully!");

        // Call the login class to log the user in
        LoginClass.getData();
        LoginClass.login();
    }
}
