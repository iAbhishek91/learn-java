package challenges.steamchallenges;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortModifyFilterSave {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
                "A61", "A42", "A93",
                "B99", "B56", "B72", "B56",
                "G89", "G12", "G23"
        );

        List<String> postProcessList = strings
                .stream()
                .filter(s -> s.startsWith("B"))
                .map(String::toLowerCase)
                .sorted() // takes a comparator
                .collect(Collectors.toList());

        postProcessList.forEach(s -> System.out.println(s));
    }
}
