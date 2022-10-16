package class_6.Client;

import class_6.Entity.Message;

import java.io.IOException;
import java.io.ObjectInputStream;

public class Listening implements Runnable {
    ObjectInputStream ois;

    public Listening(ObjectInputStream ois) {
        this.ois = ois;
    }

    @Override
    public void run() {
        System.out.println("Waiting for incoming message");
        while (true){
            try {
                Message message= (Message)ois.readObject();
                System.out.println(message.getName()+": "+message.getText());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
