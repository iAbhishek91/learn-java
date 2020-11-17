package javaBasics.lambda;

import java.util.function.Consumer;

public class ConsumerEx {
    // do not return anything
    // accept one or two(using BI)
    public static void main(String[] args) {
        Consumer<String> upper = name -> name.toUpperCase();
        Consumer<String> print = s -> System.out.println(s);

        print.andThen(upper).accept("Abhishek");
    }
}
