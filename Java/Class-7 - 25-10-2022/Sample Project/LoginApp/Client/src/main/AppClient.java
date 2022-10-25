package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import request.AppRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AppClient extends Application {

    static String hostname = "127.0.0.1";
    static int port = 3000;
    static ObjectOutputStream objectOutputStream;
    static ObjectInputStream objectInputStream;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(hostname, port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            System.out.println("Connected to the server!");
            AppClient.launch(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(AppClient.class.getResource("./../views/login_view.fxml"));
        Scene scene = new Scene(loader.load(), 500, 500);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    public static void sendRequest(AppRequest request) {
        try {
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();
            System.out.println("Request sent to server!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getResponse() {
        try {
            System.out.println("Waiting for response...");
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
