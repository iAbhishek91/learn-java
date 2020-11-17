package javaBasics.abstractclass;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(super.getName() + " m eating");
    }

    @Override
    public void breath() {
        System.out.println(super.getName() + " m beathing");
    }

    @Override
    public void walk() {
        System.out.println(super.getName() + " m walking");
    }
}
