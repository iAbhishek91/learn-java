package javaBasics.abstractClass;

public class Main {
    // abstract class cant be instantiated like interface
    public static void main(String[] args) {
        Dog parker = new Dog("Labrador");
        parker.eat();
        parker.breath();
        parker.walk();

        Parrot tiya = new Parrot("Parrot");
        tiya.fly();
        tiya.walk();
        tiya.eat();
        tiya.breath();

        Penguin pingu = new Penguin("Penguin");
        pingu.fly();
        pingu.walk();
        pingu.eat();
        pingu.breath();
    }


    //Parrot
}
