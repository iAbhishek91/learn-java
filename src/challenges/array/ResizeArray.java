package challenges.array;

import javaBasics.Array;

import java.util.Arrays;

public class ResizeArray {
    public static int[] resize(int[] arr, int newSize) {
        int[] copiedArr = arr;
        arr = new int[newSize];
        for(int i=0; i<copiedArr.length; i++) {
            arr[i] = copiedArr[i];
        }
        return arr;
    }

    // in basic Arrays  class resizing is not available, so use ArrayList if required.
    public static void main(String[] args) {
        int[] sizeFive = {1,2,3,4,5};
        sizeFive = resize(sizeFive, 7);
        sizeFive[5] = 6;
        sizeFive[6] = 7;
        System.out.println(Arrays.toString(sizeFive));
    }
}
