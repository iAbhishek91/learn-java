package javaBasics;

class Tree {
    private String name;

    public Tree(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void generateFruit () {
        System.out.println("This tree do not have fruits");
    }
}

class Mango extends Tree {
    public Mango(String name) {
        super(name);
    }

    @Override
    public void generateFruit() {
        System.out.println("Mango.......");
    }
}

class Banyan extends Tree {
    public Banyan(String name) {
        super(name);
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Banyan theBanyanTree = new Banyan("Banyan");
        Mango theMangoTree = new Mango("Mango");

        System.out.println(theBanyanTree.getName() + " tree produces ");
        theBanyanTree.generateFruit();

        System.out.println(theMangoTree.getName() +  " tree produces ");
        theMangoTree.generateFruit();
    }
}
