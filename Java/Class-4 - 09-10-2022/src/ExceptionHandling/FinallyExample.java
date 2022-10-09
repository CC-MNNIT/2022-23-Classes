package ExceptionHandling;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class FinallyExample {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = bufferedReader.readLine();
            System.out.println("Input was ===> " + input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
