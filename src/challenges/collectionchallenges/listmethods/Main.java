package challenges.collectionchallenges.listmethods;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("abhi");
        a.add("sachin");
        a.add("train");
        a.add("neem");
        a.add("audi");
        a.add("emirates");
        a.add("apple");
        a.add("laptop");
        a.add("silica");
        a.add("salt");

        // copy list: swallow
        System.out.println("--------copy list: swallow---------");
        ArrayList<String> copyA = new ArrayList<>(a);
        print(a);
        print(copyA);

        //update a and check copyA
        System.out.println("--------update a and check copyA---------");
        a.set(1, "rahul");
        print(a);
        print(copyA);

        // sort, rev sort & shuffle
        System.out.println("--------sort, rev sort & shuffle---------");
        Collections.sort(a);
        print(a);
        Collections.reverse(a);
        print(a);
        Collections.shuffle(copyA);
        print(copyA);

        // min & max
        System.out.println("--------min & max---------");
        String min = Collections.min(a);
        String max = Collections.max(a);
        System.out.println("Min: " + min + "; Max: " + max);

        // swap method
        System.out.println("-----------swap------------");
        print(a);
        Collections.swap(a,0, 1);
        print(a);
    }

    public static void print(ArrayList<String> list) {
        for(String s : list) {
            System.out.print(" " + s);
        }
        System.out.println();
    }
}
