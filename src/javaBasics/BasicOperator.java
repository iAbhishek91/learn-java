package javaBasics;

public class BasicOperator {
    public static void main(String[] args) {
        int a = 10, b = 20;
        int resultSum = a + b;
        int resultDiff = a - b;
        int resultMul = a * b;
        int resultDiv = a / b;
        int resultMod = a % b;

        System.out.println("Sum = " + resultSum);
        System.out.println("Diff = " + resultDiff);
        System.out.println("Mul = " + resultMul);
        System.out.println("Div = " + resultDiv);
        System.out.println("Mod = " + resultMod);

        // for float and double, the operator should be all in the same format
        float result1 = 5 / 2;
        System.out.println(result1); // result is NOT correct.

    }
}
