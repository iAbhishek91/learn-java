package javaBasics.generics.multipleBound;

public class Main {
    public static void main(String[] args) {
        MultipleBound<Integer, String> addInt = new MultipleBound<>(2, 8);
        addInt.add();
        System.out.println(addInt.getResult());
        
        MultipleBound<Float, String> addFloat = new MultipleBound<>(2.987f, 5.43f);
        addFloat.add();
        System.out.println(addFloat.getResult());
    }
}
