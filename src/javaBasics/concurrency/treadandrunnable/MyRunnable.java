package javaBasics.concurrency.treadandrunnable;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_RED  + "thread using runnable");
    }
}
