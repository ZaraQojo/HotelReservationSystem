package org.example.Controller;
import org.example.Model.LoginModel;
import org.example.View.LoginView;

import java.io.IOException;

public class LoginController {
    private LoginView loginView;
    private LoginModel loginModel = new LoginModel();

    public LoginController(LoginView loginView) throws IOException {
        this.loginView = loginView;
    }

    public void startLoginProcess() throws IOException {
        String username = this.loginView.getUsername();
        String password = this.loginView.getPassword();

        String user = loginModel.authenticateUser(username, password);

        if (user == null) {
            this.loginView.displayLoginError();
        }

    }
}
