package javaBasics;

import org.jetbrains.annotations.NotNull;

public class Array {
    public static void main(String[] args) {
        int[] myFirstArr = {1, 2, 3, 4, 5};
        String[] mySecondArr = new String[8];
        double[] myThirdArr = new double[7];
        int[] myFourthArr = new int[6];
        String[] myFifthArr = new String[] {"a", "b", "c", "d"};

        // NOTE: Array copy are reference by nature
        int[] myFirstCopiedArray = myFirstArr;
        String[] myCopiedSecondArr = mySecondArr;

        // assign using for loop
        for(int i =0; i < myThirdArr.length; i ++) {
            myThirdArr[i] = i *  1.6;
        }

        printArray(myThirdArr);
        printArray(myFourthArr); // values are initialised to 0
        printArray(myFifthArr);
    }

    public static void printArray (double [] arr) {
        for (double v : arr) { System.out.println(v); }
    }
    public static void printArray (int [] arr) {
        for (int value : arr) { System.out.println(value); }
    }
    public static void printArray (String [] arr) {
        for (String value : arr) { System.out.println(value); }
    }
}
