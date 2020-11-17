package javaBasics.concurrency.treadandrunnable;

public class SleepingTread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println(ThreadColor.ANSI_CYAN + currentThread().getName() + " started.");
            sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(ThreadColor.ANSI_CYAN + "Another thread interrupted me");
            return; // return from run method exits the thread
        }

        System.out.println(ThreadColor.ANSI_CYAN + currentThread().getName() + " stopped.");
    }
}
