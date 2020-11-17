package challenges.lambdachallenges;


import java.util.Comparator;

public class UseLambdaForComparatorInterface {
    public static void main(String[] args) throws Exception {
        Comparator<String> c = String::compareTo;

    }
}
