package challenges.lambdachallenges;

import java.util.Arrays;
import java.util.List;

public class SortConvertPrintStream {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        names
                .stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1,s.length()).toLowerCase())
                .peek(System.out::println)
                .sorted()
                .peek(System.out::println)
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);
    }
}
