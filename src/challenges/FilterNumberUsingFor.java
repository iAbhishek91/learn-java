package challenges;

// filter number divisible by 3 and 5
// sum all the number which are divided by 3 and 5
// print the number that matches the condition
// break the loop once 5 number satisfies the condition
// after breaking the loop print the value of the sum
public class FilterNumberUsingFor {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;

        for (int i=1; i <= 1000; i++) {
            if (i%3 == 0 && i%5 ==0) {
                count ++;
                sum += i;
                System.out.println(i + " is divisible by 3 and 5");

                if (count >= 5) break;
            }
        }

        System.out.println(sum);
    }
}
