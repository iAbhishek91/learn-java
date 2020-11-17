package javaBasics.interfaceexample;

public class Main {
    public static void main(String[] args) {
        // there is two way we can invoke the class
        // we can use the Interface name
        // (if we use interface name the flexibility to add any class which
        // implements the interface)
        // or we can use the class name directly
        ICalculator calc = new Calculator();
        System.out.println(calc.add(10, 5));
        System.out.println(calc.diff(10, 5));
        System.out.println(calc.mul(10, 5));
        System.out.println(calc.div(10, 5));
    }
}
