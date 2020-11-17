package javaBasics.lambda;

import java.util.function.IntUnaryOperator;

public class UnaryOperatorEx {
    public static void main(String[] args) {
        IntUnaryOperator add5 = num -> num + 5;
        System.out.println(add5.applyAsInt(5));
    }
}
