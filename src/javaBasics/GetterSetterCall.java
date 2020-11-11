package javaBasics;

public class GetterSetterCall {
    public static void main(String[] args) {
        GetterSetter getterSetterExample = new GetterSetter();

        getterSetterExample.setA(10);
        getterSetterExample.setB("abhishek");

        System.out.println(getterSetterExample.getA());
        System.out.println(getterSetterExample.getB());
    }
}
