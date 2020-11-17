package javaBasics.concurrency.starvation;

import static javaBasics.concurrency.treadandrunnable.ThreadColor.*;

public class Starvation {
    private final static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new SimpleThread(ANSI_CYAN), "P10");
        Thread t2 = new Thread(new SimpleThread(ANSI_BLACK), "P8");
        Thread t3 = new Thread(new SimpleThread(ANSI_GREEN), "P6");
        Thread t4 = new Thread(new SimpleThread(ANSI_RED), "P4");
        Thread t5 = new Thread(new SimpleThread(ANSI_BLUE), "P2");
        // priority is just a suggestion
        // in output mostly you will see priority is not followed
        // the its left to OS
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);
        t1.setPriority(10);

        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t1.start();
    }

    private static class SimpleThread implements Runnable {
        private final String color;

        public SimpleThread(String color) {
            this.color = color;
        }

        @Override
        public void run() {
            // all the five thread, competition for same lock object
            // this causes the starvation
            // in this example it cant be observed but in huge data processing it may, thread with lowest priority may compete for the lock
            synchronized (lock) {
                for (int i = 0; i < 100; i += 1) {
                    System.out.format(color + "%s - count %d\n", Thread.currentThread().getName(), i+1);
                }
            }
        }
    }
}
