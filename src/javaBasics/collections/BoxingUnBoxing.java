package javaBasics.collections;

import java.util.ArrayList;

public class BoxingUnBoxing {
    public static void main(String[] args) {
        // STEP-1 Define d array
        ArrayList<Integer> myIntList = new ArrayList<>();

        // STEP-2 Boxing - valueOf
        // Converting primitive type to Wrapper type; int to Integer
        for(int i = 0; i < 10; i += 1) {
            System.out.println("Index :" + i);
            myIntList.add(Integer.valueOf(i + 1));
            myIntList.add(i*10);
        }

        // STEP-3 Unboxing - <datatype>Value
        // Converting Wrapper type to primitive type; Integer to int
        for(int i=0; i < 20; i += 1) {
            System.out.println("Value of " + myIntList.get(i).intValue() + " is integer " + (myIntList.get(i) instanceof Integer));
        }
    }
}
