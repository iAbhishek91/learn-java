package javaBasics;

public class Overlaoding {

    public static int add (int a, int b) { return a + b; }
    public static int add (int a) { return a +2; }
    public static int add(float a, float b) { return (int) (a + b); }

    public static void main(String[] args) {
        System.out.println(add(1,3));
        System.out.println(add(1));
        System.out.println(add(1.5f,4.343f));
    }
}
