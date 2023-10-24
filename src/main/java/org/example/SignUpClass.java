package org.example;

// TODO: Test Wrong Parameters (Test-List) - Check Warning in Line #19

import java.util.Scanner;

public class SignUpClass {
    static Scanner sc = new Scanner(System.in);

    static UserAccountDatabase acc = new UserAccountDatabase();


    public static void signUp() {
        System.out.println("Enter username: ");
        String username = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();

        acc.addNewAccount(username, password); // TODO: Check this Warning

        System.out.println("Account created successfully!\n");

        // Call the login class to log the user in
        LoginClass.getData();
        LoginClass.login();
        if (LoginClass.userName.startsWith("SS")) {
            ViewClass.staffView();
        } else if (LoginClass.userName.startsWith("AA")) {
            ViewClass.adminView();
        }  else ViewClass.guestView();
    }
}


