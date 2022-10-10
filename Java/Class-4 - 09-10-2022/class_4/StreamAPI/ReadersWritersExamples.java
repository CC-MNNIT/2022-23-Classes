package StreamAPI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadersWritersExamples {
    /**
     * Some commonly used Readers and Writers.
     * 1. BufferedReader -> Buffered input character streams.
     * 2. BufferedWriter -> Buffered output character streams.
     * 3. FileReader -> Reads from file.
     * 4. FileWriter -> Writes to a file.
     * 5. InputStreamReader -> Reads from a byte stream and converts it to a character stream.
     * 6. OutputStreamWriter -> Reads from a character stream and converts it to a byte stream.
     */
    public static void main(String[] args) throws IOException {
//        // 1. Basic example reading from a file.
//        FileReader fileReader = new FileReader("abc.txt");
//        char [] text = new  char[4000];
//        long st = System.nanoTime();
//        int ret = fileReader.read(text);
//        System.out.println("Time taken to read ===> " + (System.nanoTime() - st));
//        System.out.println("Returned value ==> " + ret);
//        for(char e : text)
//            System.out.print(e);
//        System.out.println();
//
//        // 2. Basic writing to a file.
//        FileWriter fileWriter = new FileWriter("abc_copy.txt");
//        fileWriter.write(text);
//        fileWriter.flush();
//
//        // 3. Buffered reader.
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("abc.txt"));
//        text = new char[4000];
//        st = System.nanoTime();
//        ret = bufferedReader.read(text);
//        System.out.println("Time taken to read ===> " + (System.nanoTime() - st));
//        System.out.println("Returned value ==> " + ret);
//        for(char e : text)
//            System.out.print(e);
//        System.out.println();
    }
}
