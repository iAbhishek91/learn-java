package challenges.staticblockinitialization;


public class ClassWithStaticBlock {
    private final static int a;
    private final static int b;

    // this block is executed only one
    // when the class is loaded.
    // good for keeping any data anylysis code.
    static {
        System.out.println("I am in static block");
        a = 10;
        b = 30;
    }

    public static void print() {
        System.out.println(a + " " + b);
    }
}
