package challenges;

public class UnicodeAndChar {
    public static void main(String[] args) {
        char unicodea = '\u0985';
        char unicodev = '\u09AD';
        char unicodei = '\u09BF';
        char unicodes = '\u09B7';
        char unicodea1 = '\u09C7';
        char unicodek = '\u0995';

        // print to see the value below
        // refer https://unicode-table.com/en/
        System.out.println(unicodea+""+unicodev+unicodei+unicodes+unicodea1+unicodek);

        // same as above, string format
        String s = "\u0985\u09AD\u09BF\u09B7\u09C7\u0995";
        System.out.println(s);
    }
}
