package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.AppClient;
import request.SignupRequest;
import response.SignupResponse;

import java.io.IOException;

public class SignUpController {
    @FXML
    public AnchorPane registerPane;
    @FXML
    public Button registerButton;
    @FXML
    public Hyperlink loginLink;
    @FXML
    public TextField firstNameField;
    @FXML
    public TextField lastNameField;
    @FXML
    public TextField registrationNoField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public PasswordField confirmPasswordField;
    @FXML
    public TextField emailIDField;
    @FXML
    public Label matchLabel;

    public boolean check;

    public void switchToLogin(ActionEvent actionEvent) {
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("../views/login_view.fxml"));
        Stage stage = (Stage) loginLink.getScene().getWindow();
        Scene scene = null;
        try {
            scene = new Scene(loginLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
        stage.setTitle("Login");
    }

    public void checkIfMatches(ActionEvent actionEvent) {
        if (passwordField.getText().equals(confirmPasswordField.getText())) {
            check = true;
            matchLabel.setText("Passwords Match");
        } else {
            check = false;
            matchLabel.setText("Passwords don't match");
        }
    }

    public void register(ActionEvent actionEvent) {
        if (passwordField.getText().equals(confirmPasswordField.getText())) {
            SignupRequest registerRequest = new SignupRequest(registrationNoField.getText(), firstNameField.getText(), lastNameField.getText(), emailIDField.getText(),
                    passwordField.getText());
            AppClient.sendRequest(registerRequest);
            System.out.println("Register request sent");
            SignupResponse response = (SignupResponse) AppClient.getResponse();
            assert response != null;
            if (response.getMessage().length() == 0) {
                System.out.println("Please Try Again");
            } else {
                System.out.println("Signup success!");
                this.switchToLogin(actionEvent);
            }
        } else {
            System.out.println("Please enter correct info");
        }
    }
}