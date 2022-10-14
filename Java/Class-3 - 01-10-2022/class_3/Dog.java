package class_3;

import class_3.Mammal;

public class Dog extends Mammal {
    int weight;
    int height;
    int age;
    public Dog(int limbs, int weight, int height, int age) {
        super(limbs);
        System.out.println("Dog class constructor called");
        this.weight = weight;
        this.height = height;
        this.age = age;
        System.out.println(a);
    }
    public void bark(){

        System.out.println("Dog is barking");
    }
}
