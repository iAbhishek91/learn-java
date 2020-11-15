package challenges.inheritance;

public class Audi extends Car {
    private String model;
    private int highSpeed;
    private int speed;
    private int gear;

    public Audi(String color, String type, String model, int highSpeed) {
        this(color, type, model, highSpeed, 0,0);
    }
    public Audi(String color, String type, String model, int highSpeed, int speed, int gear) {
        super(color, type);
        this.model = model;
        this.highSpeed = highSpeed;
        this.gear = this.gear < 0 ? 0 : gear;
        this.speed = this.speed < 0 ? 0 : speed;
    }


    public void changingGear(int gear) {
        if (gear < 0) {
            this.gear = 0;
            this.speed = 0;
        } else {
            this.gear = gear;
            this.speed = gear * 20;
        }
    }


    public void dashboard() {
        System.out.println("Car: Audi; model: " + this.model + " (" + this.type + ") " +"; of color: " + this.color + ". With high speed of: " + this.highSpeed + ", with " + this.wheels + " wheels");
        System.out.println("Speed: " + this.speed);
        System.out.println("Gear:" + this.gear);
    }
}
