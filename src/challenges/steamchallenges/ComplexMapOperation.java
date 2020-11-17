package challenges.steamchallenges;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComplexMapOperation {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "A61", "A42", "A93",
                "B99", "B56", "B72", "B56",
                "G89", "G12", "G23"
        );

        String a = "abhishek";
        String b = a.substring(1);
        System.out.println(b);

        List<Integer> postStringModification = strings
                .stream()
                .map(s -> s.substring(1))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        postStringModification.forEach(System.out::println);
    }
}
