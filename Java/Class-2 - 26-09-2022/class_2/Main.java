package class_2;

public class Main {
    public static void main(String[] args) {
        // Here we are using encapsulation to achieve abstraction
        // The user is giving the inputs and calling the getDistance method
        // which returns the output.
        // The user is not concerned with the inner working of the method.
        // Only the relevant information is given out, and rest is hidden,
        // which makes it less complex and more efficient
        EuclideanDistance distance= new EuclideanDistance(3,5,7,9);
        distance.getDistance();
    }
}
