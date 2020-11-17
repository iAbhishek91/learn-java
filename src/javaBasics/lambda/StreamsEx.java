package javaBasics.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamsEx {
    // Streams are nothing to do with IO in this context.
    // they are just list of steps
    public static void main(String[] args) {
        List<String> someNum = Arrays.asList(
            "ALPHA12", "ALPHA09", "ALPHA19",
            "BETA24", "GAMMA32", "THETA60",
            "OMEGA90", "ZETA66"
        );

        List<String> usedByLambda = new ArrayList<>();

//        // step-1: add filtered
//        someNum.forEach(s -> {
//            if (s.startsWith("ALPHA")) {
//                usedByLambda.add(s);
//            }
//        });
//        // step-2: sort
//        usedByLambda.sort((s1, s2) -> s1.compareTo(s2));
//        // step-3: print
//        usedByLambda.forEach(e -> System.out.println(e));

        // requirement to use stream
        // 1. non-interfering: the source of the stream should not be changed.
        // 2. stateless: each operation is independent and process the data
        // that is passed from the previous step.
        someNum
                .stream() // should be the first call
                .filter(s -> s.startsWith("ALPHA")) // here we can't use method refs as filter accept a predicate and not a method ref
                .map(String::toUpperCase) // :: is a new operator? this is called method reference its same as s-> String.toUpperCase(s)
                .sorted()
                .forEach(System.out::println); // we cant continue after this as forEach do not return a value
        // for this reason, ForEach is called a termination operation
        // there are several termination operation, like reduce, collect
        /// the main thing is a function which do not return anything will act as a termination.

        // READ MORE: method reference on docs
        // READ MORE: Stream, they are really powerful

    }

}
