package StreamAPI;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SerializationExample {
    /**
     * The streams used in reading and writing objects are,
     *
     * 1. ObjectInputStream -> Takes a Serializable object and converts it to a stream.
     * 2. ObjectOutputStream -> Takes a byte stream and converts it to an Object.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1. First example.
        //      - Taking an object.
        SerializableObject serializableObject = new SerializableObject(5, 6);
        System.out.println(serializableObject.a);
        System.out.println(serializableObject.b);
        System.out.println(serializableObject.al1);
        System.out.println(serializableObject.al2);

        //      - Converting it to a stream and writing it to a file.
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.ser"));
        objectOutputStream.writeObject(serializableObject);

        //      - Converting the stream back to the object by reading the file.
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.ser"));
        Object o = objectInputStream.readObject();

        //      - Verifying the object.
        SerializableObject serializableObject1 = (SerializableObject) o;
        System.out.println(serializableObject1.a);
        System.out.println(serializableObject1.b);
        System.out.println(serializableObject1.al1);
        System.out.println(serializableObject1.al2);
    }
}

class SerializableObject implements Serializable {
    public int a;
    public transient int b;

    public ArrayList<Integer> al1;
    public transient ArrayList<Integer> al2;
    SerializableObject(int a, int b) {
        this.a = a;
        this.b = b;
        al1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        al2 = new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8));
    }
}
