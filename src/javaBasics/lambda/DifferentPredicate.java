package javaBasics.lambda;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;

public class DifferentPredicate {
    // there are different types of predicate, use appropriate one for readability
    public static void main(String[] args) {
        IntPredicate intPredicate = num -> num > 23;

        System.out.println(intPredicate.test(24));
        System.out.println(intPredicate.test(2));

        DoublePredicate doublePredicate = dbl -> dbl > 23.789d;

        System.out.println(doublePredicate.test(23.788d));
        System.out.println(doublePredicate.test(23.790d));
    }
}
