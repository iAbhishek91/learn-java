package javaBasics;

public class ConditionalStatements {

    private int ifStatements(int value) {
        if (value > 5) return 1;
        return 0;
    }

    private static String ifElseStatements(String value) {
        if (value.equals("abhishek")) return "it's me";
        else return "someone Else";
    }

    private static String switchStatements(String a) {
        switch (a) {
            case "add": return "add";
            case "diff": return "diff";
            case "mul": return "mul";
            case "div": return "div";
            default: return "false";
        }
    }

    // numbers are also allowed
    private static String switchStatements(int a) {
        switch (a) {
            case 1: return "add";
            case 2: return "diff";
            case 3: return "mul";
            case 4: return "div";
            default: return "false";
        }
    }

    public static void main(String[] args) {
        int ifValue = 10;
        String ifElseValue = "Abhishek";
        String switchValue1 = "add";
        int switchValue2 = 3;
        ConditionalStatements myObj = new ConditionalStatements();

        System.out.println(myObj.ifStatements(ifValue));
        System.out.println(ifElseStatements(ifElseValue));
        System.out.println(switchStatements(switchValue1));
        System.out.println(switchStatements(switchValue2));
    }
}
