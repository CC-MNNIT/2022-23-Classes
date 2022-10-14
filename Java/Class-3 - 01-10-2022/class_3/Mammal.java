package class_3;

public class Mammal extends LivingBeing {
    int limbs;

    public Mammal() {
        System.out.println("Initialising cat ");
    }

    public Mammal(int limbs){
        System.out.println("Mammal class constructor called");
        this.limbs=limbs;
    }
    public void reproduce(){
        System.out.println("Mammal is Giving birth to young ones");
    }
    public void produceMilk(){
        System.out.println("Mammal is Producing milk through mammary glands");
    }

    @Override
    public void breathe() {
        System.out.println("Mammal is Breathing using lungs");
    }
}
