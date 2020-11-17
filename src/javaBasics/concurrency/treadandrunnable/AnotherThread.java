package javaBasics.concurrency.treadandrunnable;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from " + currentThread().getName());
    }
}
