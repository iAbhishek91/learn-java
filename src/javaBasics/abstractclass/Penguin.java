package javaBasics.abstractclass;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(super.getName() + " Sorry I can't fly.");
    }
}
