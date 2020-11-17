package javaBasics.nestedclasses;

public class Main {
    public static void main(String[] args) {
        Bike pulsar = new Bike("Pulsar 180");
        pulsar.printDetails();
        // the below syntax is imp
        Bike.FuelTank fuelTank = pulsar.new FuelTank(15);
        System.out.println(fuelTank.fullTankPrice(70.9));
    }
}
