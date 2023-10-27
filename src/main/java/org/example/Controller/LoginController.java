package org.example.Controller;
import org.example.Model.LoginModel;
import org.example.User;
import org.example.View.LoginView;

public class LoginController {

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginController(LoginView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;
    }

    public LoginController(LoginView loginView) {

    }

    public User startLoginProcess() {
        while (true) {
            int choice = loginView.getChoice();

            switch (choice) {
                case 1:
                    String username = loginView.getUsername();
                    String password = loginView.getPassword();
                    String userRole = loginModel.authenticateUser(username, password);

                    if (userRole != null) {
                        loginView.displayMessage("Login successful. You are a " + userRole);
                    } else {
                        loginView.displayMessage("Login failed. Invalid username or password.");
                    }
                    break;
                case 2:
                    loginView.displayMessage("Exiting the system.");
                    return null;
                default:
                    loginView.displayMessage("Invalid choice. Please try again.");
            }
        }
    }
}