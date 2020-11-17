package javaBasics.abstractclass;

public abstract class Bird extends Animal{
    public Bird(String name) {
        super(name);
    }

    // abstract methods should be implemented in the inheritance chain
    @Override
    public void eat() {
        System.out.println(super.getName() + " is eating.");
    }

    @Override
    public void breath() {
        System.out.println(super.getName() + " is breathing.");
    }

    @Override
    public void walk() {
        System.out.println(super.getName() + " is walking");
    }

    public abstract  void fly();
}
