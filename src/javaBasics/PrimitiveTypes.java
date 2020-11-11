package javaBasics;

// primitive data types are: int, long, short, float, double, boolean, byte, char
public class PrimitiveTypes {
    public static void main(String[] args) {
        // same as 10000, allowed after java 7 and above
        int i = 10_000;
        // wrapper class
        // all primitive type have wrapper classes
        // OVERFLOW and UNDERFLOW: more than max & less than min
        int minIntValue = Integer.MIN_VALUE;
        int maxIntValue = Integer.MAX_VALUE;

        System.out.println("Value of i: " + i); // 32 bits
        System.out.println("Max and Min value of integer are: "+ minIntValue + " ; " + maxIntValue);

        long l = 10; // 64 bits
        long minLongValue = Long.MIN_VALUE;
        long maxLongValue = Long.MAX_VALUE;

        System.out.println("Value of l: " + l);
        System.out.println("Max and Min value of long are: "+ minLongValue + " ; " + maxLongValue);

        short s = 10; // 16 bits
        short minShortValue = Short.MIN_VALUE;
        short maxShortValue = Short.MAX_VALUE;

        System.out.println("Value of s: " + s);
        System.out.println("Max and Min value of short are: "+ minShortValue + " ; " + maxShortValue);

        // NOTE: Both float and double are not great for doing high precision calculation.
        // this is due to the fact that float have a basic problem, and nothing to do with java
        // Java uses "BigDecimal" to solve this problem

        // f is required for floating as double is default.
        // 'f' is not required if the number is whole number.
        float f = 10.35f;
        float f1 = (float) 10.35; //casting double to float
        float minFloatValue = Float.MIN_VALUE;
        float maxFloatValue = Float.MAX_VALUE;

        System.out.println("Value of f & f1: " + f + f1);
        System.out.println("Max and Min value of float are: "+ minFloatValue + " ; " + maxFloatValue);

        // double are preferred over float:
        //  as double are fast to process and
        //  few libraries support double by default
        double d = 10.35;
        double minDoubleValue = Double.MIN_VALUE;
        double maxDoubleValue = Double.MAX_VALUE;

        System.out.println("Value of d: " + d);
        System.out.println("Max and Min value of double are: "+ minDoubleValue + " ; " + maxDoubleValue);

        // can store any unicode value
        // 65535, unicode also required 16 bits to represent any char
        char c = 'a'; // 16 bits
        System.out.println("Value of c: " + c);

        boolean bool = true;
        System.out.println("Value of bool: " + bool);

        byte b = 's'; // 8 bits
        byte minByteValue = Byte.MIN_VALUE;
        byte maxByteValue = Byte.MAX_VALUE;
        System.out.println("Value of b:" + b);
        System.out.println("Max and Min value of double are: "+ minByteValue + " ; " + maxByteValue);
    }
}
