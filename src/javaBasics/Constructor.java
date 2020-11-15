package javaBasics;

public class Constructor {
    int a= -1, b = -1;

    // Constructor calling another constructor
    public Constructor() {
        this(0, 0);
    }

    public Constructor(int a, int b) {
        // NOTE: we can use setter here to set the value instead of
        // directly assigning value to properties.
        // However, setting value directly is preferred way of doing.
        // Hence with constructors, generally setter are not used in practice.
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Constructor defaultVal = new Constructor();
        System.out.println("Default Value: " + defaultVal.a + "&" + defaultVal.b);

        Constructor customVal = new Constructor(10, 5);
        System.out.println("Default Value: " + customVal.a + "& its " + customVal.b);
    }

}
