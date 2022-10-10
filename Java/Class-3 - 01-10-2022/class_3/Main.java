package class_3;

public class Main {
    public static void main(String[] args) {
       // INHERITANCE
        Dog dog= new Dog(4,25,150,3);
        dog.grow();
        dog.breathe();
        dog.move();
        // the above three methods are inherited from the living being class.

        dog.reproduce();
        dog.produceMilk();
        // the above two methods have been inherited from the mammal class.
        dog.bark();


       //  METHOD OVERLOADING
        Dimension shape=new Dimension();
        shape.CalculateArea(7.2); // At compile time,using the parameter list it identifies the method to be called
        shape.CalculateArea(5,3);
        shape.CalculateArea(4);

         //METHOD OVERRIDING
        LivingBeing object= new LivingBeing();
        object.breathe();

        LivingBeing obj = new Mammal(4); //at compile time the reference type of the object is Living Being
        obj.breathe();                          // so at compile time it takes a decision that the breathe method of
//                                                   Living being has to called. However at runtime it realises that the
//                                                   actual type of the object is Mammal, and it OVERRIDES its previous
//                                                 decision and calls the breathe method of Mammal class




       //  TO STRING
        Student s1=new Student(101,"Raj","lucknow");
        Student s2=new Student(102,"Vijay","ghaziabad");

        System.out.println(s1);//compiler writes here s1.toString()
        System.out.println(s2);//compiler writes here s2.toString()

        // EQUALS
        Complex c1 = new Complex(10, 15);
        Complex c2 = new Complex(10, 15);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1.equals(c2));
    }
}
