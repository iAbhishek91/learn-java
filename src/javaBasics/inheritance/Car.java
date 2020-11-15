package javaBasics.inheritance;

public class Car {
    String brand;
    String color;
    int wheels;

    public Car(String brand, String color, int wheels) {
        this.brand = brand;
        this.color = color;
        this.wheels = wheels;
    }

    public void showCar() {
        System.out.println("My car is " + this.color + ", and it's a " + this.brand);
    }
}
