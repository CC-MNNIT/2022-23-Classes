package class_6.Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server{
    static ArrayList<ObjectOutputStream>list = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket;
        try {
            serverSocket = new ServerSocket(6969);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            assert serverSocket != null;
            try {
                socket=serverSocket.accept();
                System.out.println("Socket Connection made" );
                Thread t=new Thread(new Handler(socket));
                t.start();
                System.out.println("Handler thread started");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
