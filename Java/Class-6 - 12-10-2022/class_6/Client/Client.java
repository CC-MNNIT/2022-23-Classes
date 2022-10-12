package class_6.Client;


import class_6.Entity.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket;
        ObjectOutputStream oos;
        ObjectInputStream ois;
        String name,text;
        try {
            //creating a new socket connection
            socket = new Socket("localhost", 6969);
            System.out.println("Connected to server");
            // assigning the input and output streams
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());

            //Starting a new thread for listening to incoming messages
            Thread thread=new Thread(new Listening(ois));
            thread.start();
            System.out.println("Listening thread established");
            //Current thread will be used for sending the messages
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter your name");
            name=scanner.nextLine();
            while (true){
                text=scanner.nextLine();
                //System.out.println("Input detected");
                SendMessage(oos,name,text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void SendMessage(ObjectOutputStream objectOutputStream, String name, String text){
        try {
            objectOutputStream.writeObject(new Message(name,text));
            //System.out.println("MESSAGE SENT TO SERVER");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
