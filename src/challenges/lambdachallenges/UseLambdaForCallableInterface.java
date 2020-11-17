package challenges.lambdachallenges;

import java.util.concurrent.Callable;

public class UseLambdaForCallableInterface {
    public static void main(String[] args) throws Exception {
        Callable<String> c= () -> "Abhishek";

        String f = c.call();

        System.out.println(f);
    }
}
