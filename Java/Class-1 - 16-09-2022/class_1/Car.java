package class_1;

import java.sql.SQLOutput;

public class Car {
    public static String brand,model;
    private int year;
    private String transmission;

//    public class_1.Car(String brand, String model, int year, String transmission) {
//        this.brand = brand;
//        this.model = model;
//        this.year = year;
//        this.transmission = transmission;
//    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void Ignition(){
        System.out.println("Starting the car");
    }

    public void Brake(){
        System.out.println("Applying brakes");
    }

    public void Accelerate(){
        System.out.println("Accelerating");
    }

    public void Clutch(){
        if(transmission.equals("AUTOMATIC")) System.out.println("No clutch in this model");
        else System.out.println("Clutch pressed");
    }

}

