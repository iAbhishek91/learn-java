package javaBasics;

public class Casting {
    public static void main(String[] args) {
        byte maxByteValue = Byte.MAX_VALUE;
        short maxShortValue = Short.MAX_VALUE;

        // int casted to byte
        byte resultByte = (byte) (maxByteValue / 2);
        // int casted by short
        short resultShort = (short) (maxShortValue / 2);

        System.out.println("Half of max byte value is: " + resultByte + " : " + resultShort);

        // challenge
        byte myByte = 'Y';
        short myShort = 123;
        int myInt = 123;
        long result = 50000L + (10L * ( myByte + myShort + myInt));
        System.out.println(result);
    }
}
