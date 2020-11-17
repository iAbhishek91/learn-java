package challenges.lambdachallenges;

import java.util.function.Function;

public class CustomFunctionToAcceptFunction {
    public static void main(String[] args) {
        Function<String, String> f = source -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i =0; i < source.length(); i += 1) {
                if(i%2 == 1) {
                    returnVal.append(i);
                }
            }

            return returnVal.toString();
        };

        System.out.println(everySecondCharacter(f, "1234567890"));
    }

    public static String everySecondCharacter(Function<String,String> f, String s) {
        return f.apply(s);
    }
}
