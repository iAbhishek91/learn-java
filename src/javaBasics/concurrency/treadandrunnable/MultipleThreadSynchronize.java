package javaBasics.concurrency.treadandrunnable;

import static javaBasics.concurrency.treadandrunnable.ThreadColor.*;

public class MultipleThreadSynchronize {
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


class CountDownSync {
    private int j; // in heap
    // avoid race condition
    // provide a lock with a thread, until a lock is released
    // any method can be sync, both static, non static
    // constructor cant be synced
    // we can sync a blk of code as well
    // but in that case don't use local variable apart from string
    synchronized void doCountDown() {
        String color;

        if (Thread.currentThread().getName().equals("T1")) { color = ANSI_CYAN; }
        else if (Thread.currentThread().getName().equals("T2")) { color = ANSI_GREEN; }
        else{ color = ANSI_RED; }
        // Value of "i" is in the thread stack, so both the thread will run for 5 times
        // However if we keep the variable "j" outside local scope, the var will br in the heap
        // so they can share
        synchronized (this) {
            for (int i = 10; i >= 1; i--) {
                System.out.println(color + Thread.currentThread().getName() + " - I: " + i);
            }
            for (j = 10; j >= 1; j--) {
                System.out.println(color + Thread.currentThread().getName() + " - J: " + j);
            }
        }
    }
}


class CountDownThreadSync extends Thread {
    private final CountDownSync countDownSync;

    public CountDownThreadSync(CountDownSync countDownSync) {
        this.countDownSync = countDownSync;
    }

    @Override
    public void run() {
        countDownSync.doCountDown();
    }
}