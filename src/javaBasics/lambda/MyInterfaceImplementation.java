package javaBasics.lambda;

public class MyInterfaceImplementation {
    public static void main(String[] args) {
        // below implementation is NOT lambda, see how labmda have shorten the code
//        print(new MyInterface() {
//            @Override
//            public void printHello(String message) {
//                System.out.println("Hello " + message);
//            }
//        });

        MyInterface myLambda = name-> System.out.println("Lambda says Hello " + name);
        print(myLambda);
    }

    public static void print(MyInterface i) {
        i.printHello("Abhishek");
    }

}
