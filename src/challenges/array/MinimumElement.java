package challenges.array;

public class MinimumElement {
    public static void main(String[] args) {
        int[] myArr = {1, 4, 55, 0 , -5, -88, 98};

        int min = findMinimum(myArr);

        System.out.println("Minimum Array:" + min);
    }

    public static int findMinimum(int[] arr) {
        int min = arr[0];
        for(int curr:arr) {
            min = Math.min(min, curr);
        }
        return min;
    }
}
