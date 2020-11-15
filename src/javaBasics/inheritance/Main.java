package javaBasics.inheritance;

// All class in JAVA inherits from Object class from java.lang
public class Main extends Car{
    String logoShape;

    public Main(String brand, String color, String logoShape) {
        super(brand, color, 4);
        this.logoShape = logoShape;
    }

    @Override
    public void showCar() {
        System.out.println(this.brand + " " + this.color + " " + this.logoShape);

        // example of calling parent method
        // this cant be done form static methods, hence NOT from main.
        super.showCar();
    }

    public static void main(String[] args) {
        Main abhi = new Main("Audi", "black", "fourCircle");
        abhi.showCar();
    }
}
