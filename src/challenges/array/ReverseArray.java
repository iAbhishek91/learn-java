package challenges.array;

import java.util.Arrays;

public class ReverseArray {
    public static void reverseArr(int[] arr) {
        int temp;
        for(int i = 0; i < arr.length / 2 ; i ++) {
            temp = arr[i];
            arr[i] = arr[arr.length-(i+1)];
            arr[arr.length-(i+1)] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        System.out.println(Arrays.toString(arr));

        reverseArr(arr);

        System.out.println(Arrays.toString(arr));
    }
}
