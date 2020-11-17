package javaBasics.concurrency.treadandrunnable;

import static javaBasics.concurrency.treadandrunnable.ThreadColor.*;

public class MultipleThread {
    public static void main(String[] args) {
        CountDownSync countDownSync = new CountDownSync();

        CountDownThreadSync t1 = new CountDownThreadSync(countDownSync);
        t1.setName("T1");
        t1.start();

        CountDownThreadSync t2 = new CountDownThreadSync(countDownSync);
        t2.setName("T2");
        t2.start();
    }
}


class CountDown {
    private int j; // in heap
    void doCountDown() {
        String color;

        if (Thread.currentThread().getName().equals("T1")) { color = ANSI_CYAN; }
        else if (Thread.currentThread().getName().equals("T2")) { color = ANSI_GREEN; }
        else{ color = ANSI_RED; }
        // Local object, are saved in thread stack, but values are stored on the heap
        // but for local primitive type both are on the thread stack
        // Value of "i" is in the thread stack, so both the thread will run for 5 times
        // However if we keep the variable "j" outside local scope, the var will br in the heap
        // so they can share
        for (int i = 10 ; i >= 1; i --) {
            System.out.println(color + Thread.currentThread().getName() + " - I: " + i);
        }
        for (j =10 ; j >= 1; j --) {
            System.out.println(color + Thread.currentThread().getName() + " - J: " + j);
        }
    }
}


class CountDownTread extends Thread {
    private final CountDownSync countDownSync;

    public CountDownTread(CountDownSync countDownSync) {
        this.countDownSync = countDownSync;
    }

    @Override
    public void run() {
        countDownSync.doCountDown();
    }
}