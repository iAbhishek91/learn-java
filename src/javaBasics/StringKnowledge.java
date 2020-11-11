package javaBasics;

public class StringKnowledge {
    public static void main(String[] args) {
        // NOTE: String in java are immutable
        // any modification will make a copy of the actual string instead of modifying the same one.
        String a = "Abhishek is learning JAVA in depth";

        System.out.println(a.length()); // find length of a string

        System.out.println(a.split(" ")[3]); // split

        // NOTE: this is not best way to do append, we can use StringBuffer
        System.out.println(a + "appended"); // concat

        // extract string/char from the string
        System.out.println(a.charAt(10)); // find char at
        System.out.println(a.substring(8, 11)); // substring


        // conversion
        String PI = "3.14";
        String number = "1";
        System.out.println((Float.parseFloat(PI) + 1f));
        System.out.println(Integer.parseInt(number));
    }
}
