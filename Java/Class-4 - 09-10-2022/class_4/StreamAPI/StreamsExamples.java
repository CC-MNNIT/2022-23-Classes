package StreamAPI;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamsExamples {
    /**
     * Some commonly used input and output streams.
     *
     * 1. BufferedInputStream -> Buffered input stream (duh)
     * 2. BufferedOutputStream -> Buffered output stream (duh)
     * 3. FileInputStream -> Input stream from that reads from a file.
     * 4. FileOutputStream -> Output stream that writes to a file.
     * 5. ObjectInputStream -> Input stream for objects. (Will clarify during Serialization).
     * 6. ObjectOutputStream -> Output stream for objects.
     * 7. PrintStream -> The type of System.out variable. Contains print() and println().
     */
    public static void main(String[] args) {

//        // 1. Basic first example. Reading from and writing to a file.
//
//        FileInputStream fileInputStream = new FileInputStream("abc.txt");
//        long st = System.nanoTime();
//        byte [] fileContent = fileInputStream.readAllBytes();
//        System.out.println("Total time taken ==> " + (System.nanoTime()-st));
//        for (byte b : fileContent) {
//            System.out.println((char) b);
//        }
//        fileInputStream.close();
//
//        // 2. Reading an image file.
//
//        fileInputStream = new FileInputStream("img.png");
//        fileContent = fileInputStream.readAllBytes();
//        for (byte b : fileContent) {
//            System.out.println((char) b);
//        }
//        fileInputStream.close();
//
//        // 3. Buffering streams.
//
//        fileInputStream = new FileInputStream("abc.txt");
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//        st = System.nanoTime();
//        fileContent = bufferedInputStream.readAllBytes();
//        System.out.println("Total time taken ==> " + (System.nanoTime()-st));
//        for (byte b : fileContent) {
//            System.out.println((char) b);
//        }
    }
}
