package javaBasics.generics.withOutGenerics;

public abstract class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name of the player: " + name;
    }
}
