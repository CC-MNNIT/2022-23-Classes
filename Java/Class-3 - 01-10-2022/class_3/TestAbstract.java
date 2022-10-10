package class_3;

// Abstract class
abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void animalSound();
    // Regular method
    public void sleep() {
        System.out.println("Zzz");
    }
}

// Subclass (inherit from Animal)
class Pig extends Animal {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }
}

public class TestAbstract {
    public static void main(String[] args) {
        Animal myPig = new Pig(); // Create a Pig object
        myPig.animalSound();
        myPig.sleep();
    }
}