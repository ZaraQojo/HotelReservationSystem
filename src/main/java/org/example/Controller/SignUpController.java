package org.example.Controller;

import org.example.Model.SignUpModel;
import org.example.View.SignUpView;

public class SignUpController {

    private SignUpView signUpView;
    private SignUpModel signUpModel;

    public SignUpController(SignUpView signUpView, SignUpModel signUpModel) {
        this.signUpView = signUpView;
        this.signUpModel = signUpModel;
    }

    public void startSignUpProcess() {
        signUpView.displayWelcomeMessage();

        String username = signUpView.getUsername();
        String password = signUpView.getPassword();

        signUpModel.addGuestUser(username, password);

        signUpView.displaySuccessMessage("Guest");
    }
}