package challenges.lambdachallenges;

import java.util.Arrays;
import java.util.function.Function;

public class ConvertCustomMethodToLambda {
    public static void main(String[] args) {
        System.out.println(everySecondChar("Abhishek is practicing lambda"));

        Function<String, String> f = source -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i =0; i < source.length(); i += 1) {
                if(i%2 == 1) {
                    returnVal.append(i);
                }
            }

            return returnVal.toString();
        };

        // to execute we need something like below
        System.out.println(f.apply("1234567890"));

    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for(int i =0; i < source.length(); i += 1) {
            if(i%2 == 1) {
                returnVal.append(i);
            }
        }

        return returnVal.toString();
    }
}
