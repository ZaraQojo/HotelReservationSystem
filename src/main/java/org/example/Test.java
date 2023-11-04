package org.example;

import org.example.Controller.LoginController;
import org.example.View.LoginView;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);


        System.out.println("Welcome To The System");
        int choice;

        choice = loginView.getChoice();

        if (choice == 1) {
            loginController.startLoginProcess();
        } else System.exit(0);


    }

}
