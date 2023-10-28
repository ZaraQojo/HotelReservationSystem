package org.example.Controller;
import org.example.User;
import org.example.View.LoginView;
import org.example.services.UserService;

import java.io.IOException;

public class LoginController {
    private LoginView loginView;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
    }

    public User startLoginProcess() throws IOException {
        String username = this.loginView.getUsername();
        String password = this.loginView.getPassword();

        User user = UserService.authenticateUser(username, password);

        if (user == null) {
            this.loginView.displayLoginError();
            return null;
        }

        return user;
    }
}
