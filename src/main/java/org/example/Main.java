package org.example;

// TODO: Test Wrong Parameters (Test-List) - Study Socket Adding for the project
// TODO: Adding JAR Files to import
// TODO: Check Ayan Pull-Request
// TODO: add marsel

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====Welcome to Marsel Hotel=====\n\n\n1-Login\n2-Signup");
        int pro = sc.nextInt();
        if (pro == 1) {
            if (LoginClass.login()) {
                if (LoginClass.userName.startsWith("SS")) {
                    ViewClass.staffView();
                } else if (LoginClass.userName.startsWith("AA")) {
                    ViewClass.adminView();
                } else ViewClass.guestView();
            }
        } else if (pro == 2) {
            SignUpClass.signUp();
        } else
            System.out.println("Wrong Input");


    }
}


// TODO: Check Static and non-Static Usage
// TODO: Check the need of call by Class or Call by Objects