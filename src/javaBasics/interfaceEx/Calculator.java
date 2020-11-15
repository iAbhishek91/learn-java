package javaBasics.interfaceEx;

// Multiple inheritance is allowed only via interface

public class Calculator implements  ICalculator{
    // When in implement a interface all the methods needs to be implemented

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int diff(int a, int b) {
        return a-b;
    }

    @Override
    public int mul(int a, int b) {
        return a*b;
    }

    @Override
    public int div(int a, int b) {
        return a/b;
    }
}
