package main;

import request.AppRequest;
import request.LoginRequest;
import request.SignupRequest;
import services.DatabaseServices;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    Socket socket;
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;

    public ClientHandler(Socket socket) throws Exception {
        this.socket = socket;
        this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        this.objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        System.out.println("Client connected... waiting for requests.");
        while (true) {
            try {
                AppRequest request = (AppRequest) objectInputStream.readObject();
                System.out.println("Received request");
                switch (request.getRequestType()) {
                    case LOGIN_REQUEST -> {
                        System.out.println("Client wants to login!");
                        LoginRequest loginRequest = (LoginRequest) request;
                        System.out.println("Email: " + loginRequest.getEmail());
                        objectOutputStream.writeObject(DatabaseServices.loginUser(loginRequest));
                        objectOutputStream.flush();
                    }
                    case SIGNUP_REQUEST -> {
                        System.out.println("Client wants to signup!");
                        SignupRequest signupRequest = (SignupRequest) request;
                        System.out.println("Email: " + signupRequest.getEmail());
                        objectOutputStream.writeObject(DatabaseServices.createUser(signupRequest));
                        objectOutputStream.flush();
                    }
                }
            } catch (Exception e) {
                break;
            }
        }

        System.out.println("Client disconnected!");

        try {
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
        } catch (Exception ignored) {

        }
    }
}
