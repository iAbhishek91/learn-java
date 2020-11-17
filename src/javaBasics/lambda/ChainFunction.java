package javaBasics.lambda;

import java.util.function.Function;

public class ChainFunction {
    public static void main(String[] args) {
        Function<Integer, Integer> addTwo = num -> num + 2;
        Function<Integer, Integer> addThree = num -> num + 3;

        System.out.println(addTwo.andThen(addThree).apply(10));
    }
}
