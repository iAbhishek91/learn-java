package javaBasics;

public class Loops {
    public static void forLoop(int times) {
        for (int i = 1; i <= times; i ++) {
            System.out.println("Round for : " + i);
        }
    }

    public static void whileLoop(int value) {
        int count = 1;

        while (count < value) {
            System.out.println("Round while : " + count);
            count ++;
        }
    }

    public static void doLoop(int value) {
        int count = 1;

        do {
            System.out.println("Round do : " + count);
            value --;
        } while(count < value) ;
    }

    public static void main(String[] args) {
        forLoop(3);
        whileLoop(5);
        doLoop(4);
    }
}
