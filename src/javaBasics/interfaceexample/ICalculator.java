package javaBasics.interfaceexample;

public interface ICalculator {
    // access specifier are not required as all should be public by default
    int add(int a, int b);
    int diff(int a, int b);
    int mul(int a, int b);
    int div(int a, int b);
}
