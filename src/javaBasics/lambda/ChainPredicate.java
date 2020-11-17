package javaBasics.lambda;

import java.util.function.IntPredicate;

public class ChainPredicate {
    public static void main(String[] args) {
        IntPredicate test1 = n -> n > 60;
        IntPredicate test2 = n -> n < 80;
        IntPredicate test3 = n -> n < 32;


        System.out.println(test1.and(test2).test(78));
        System.out.println(test1.or(test3).test(30));
    }
}
