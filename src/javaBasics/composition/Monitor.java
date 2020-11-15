package javaBasics.composition;

public class Monitor {
    private String brand;
    private double price;
    // this is composition
    // which is different from inheritance
    Resolution resolution;

    public Monitor(String brand, double price, Resolution resolution) {
        this.brand = brand;
        this.price = price;
        this.resolution = resolution;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private Resolution getResolution() {
        return resolution;
    }

    public void configureResolution() {
        getResolution().configureResolution();
    }

    public void showFeatures () {
        System.out.println("Brand: " + this.brand + "; price: " + this.price + "; with resolution: " + this.resolution.getHeight() + " : " + this.resolution.getWidth());
    }
}
