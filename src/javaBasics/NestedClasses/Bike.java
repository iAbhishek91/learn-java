package javaBasics.NestedClasses;

public class Bike {
    private final String name;

    public Bike(String name) {
        this.name = name;
    }

    public void printDetails() {
        System.out.println("Name: " + this.name);
    }

    // best practice to keep inner classes as private
    public class FuelTank {
        private final double capacity;

        public FuelTank(double capacity) {
            this.capacity = capacity;
        }

        public double fullTankPrice(double pricePerLiter) {
            return capacity * pricePerLiter;
        }
    }
}
