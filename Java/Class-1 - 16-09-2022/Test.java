public class Test {

    public static void main(String[] args) {

        Car verna = new Car("Verna", "Hyundai", "Blue");
        Car thar = new Car("Thar", "Mahindra", "Black");

//        verna.brand = "Hyundai";
//        verna.color = "Black";
//        verna.model = "Verna";

        verna.accelerate();
        verna.brake();
    }

}
