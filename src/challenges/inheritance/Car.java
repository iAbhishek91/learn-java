package challenges.inheritance;

public class Car extends Vehicle{
    protected String type;

    public Car(String color, String type) {
        super(4, color,"LMV");
        this.type = type;
    }
}
