package services;

import main.AppServer;
import request.LoginRequest;
import request.SignupRequest;
import response.LoginResponse;
import response.SignupResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseServices {

    public static SignupResponse createUser(SignupRequest signupRequest) {
        Connection connection = AppServer.getConnection();
        String query = "INSERT INTO STUDENT (REG_NO, FIRST_NAME, LAST_NAME, EMAIL, PASS) VALUES (?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, signupRequest.getRegistrationNumber());
            preparedStatement.setString(2, signupRequest.getFirstName());
            preparedStatement.setString(3, signupRequest.getLastName());
            preparedStatement.setString(4, signupRequest.getEmail());
            preparedStatement.setString(5, signupRequest.getPassword());
            int res = preparedStatement.executeUpdate();
            if (res != 1) {
                return new SignupResponse("FAILED!");
            } else {
                return new SignupResponse("SUCCESS!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new SignupResponse("FAILED!");
    }

    public static LoginResponse loginUser(LoginRequest loginRequest) {
        Connection connection = AppServer.getConnection();
        String query = "SELECT REG_NO, EMAIL, FIRST_NAME, LAST_NAME FROM STUDENT WHERE EMAIL = ? AND PASS = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, loginRequest.getEmail());
            preparedStatement.setString(2, loginRequest.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                String regNo = resultSet.getString(1);
                String email = resultSet.getString(2);
                String firstName = resultSet.getString(3);
                String lastName = resultSet.getString(4);
                return new LoginResponse(firstName, lastName, email, regNo);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
