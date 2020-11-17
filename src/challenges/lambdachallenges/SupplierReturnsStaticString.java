package challenges.lambdachallenges;

import java.util.function.Supplier;

public class SupplierReturnsStaticString {
    public static void main(String[] args) {
        Supplier<String> iLoveJava = () -> "I love Java!";

        System.out.println(iLoveJava.get());
    }
}
