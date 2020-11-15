package javaBasics;

public class StaticMethodProperties {
    private int a;

    // final variable cant be initialized by constructor
    private final int a1 = 10;

    //NOTE: this are constants
    // can be initialized by constructor
    // instead of this.b = b; we use StaticMethodProperties.b = b
    // Also static vars contains the last value assigned via object.
    private static int b;

    public StaticMethodProperties(int a, int b) {
        this.a = a;
        StaticMethodProperties.b = b;
    }

    public static void showStatic() {
        //NOTE: Static method do not have access to instance method
        // Also static method are used where data is not required
        // or are always common consuming static method
        System.out.println("static method" + b);
    }

    // instance can access both instance and static variables
    public void showInstance() {
        System.out.println("instance" + a);
        System.out.println("instance final" + a1);
        System.out.println("static" + b);
    }

    public static void main(String[] args) {
        StaticMethodProperties instance1 = new StaticMethodProperties(10, 20);
        StaticMethodProperties instance2 = new StaticMethodProperties(11, 21);
        instance1.showInstance();
        instance2.showInstance();
        StaticMethodProperties.showStatic();
    }
}
