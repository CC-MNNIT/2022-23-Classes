public class Car {

    String model;
    String color;
    String brand;

//    public Car() {
//        System.out.println("Generating a car!");
//    }

    public Car(String model, String brand, String color) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        System.out.println("Generating a car with specified properties: " + color + ",  " + brand + ", " + model);
    }

    public void accelerate() {
        System.out.println("Car is accelerating!");
    }

    public void brake() {
        System.out.println("Car is decelerating!");
    }

}


