package javaBasics.concurrency.treadandrunnable;


public class Main {
    public static void main(String[] args) {
        // the order of output is not guaranteed
        System.out.println(ThreadColor.ANSI_BLUE + "Hello from main thread.");


        Thread anotherThread = new AnotherThread();
        anotherThread.setName("Thread-1");
        // start the other thread, using start as JVM will start the thread instead
        anotherThread.start();
        anotherThread.run(); // this code is not running within the thread, instead from the main


        // use of anonymous class, this is imp if we have to run the code only once
        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "anonymous class implementation of thread");
            }
        }.start();


        // another way to implement thread
        MyRunnable myRunnableThread1 = new MyRunnable();
        myRunnableThread1.run(); // this is not the appropriate way, as the code will in main method
        Thread myRunnableThread2  = new Thread(new MyRunnable()); // this is possible as thread has constructor which takes a runnable implemented class
        myRunnableThread2.start();


        // INTERRUPT a thread
        Thread sleepingTread = new SleepingTread();
        sleepingTread.setName("Sleeping thread-1");
        sleepingTread.start();
        sleepingTread.interrupt(); // sends an interrupt to the thread, throws an Interrupted exception


        // join a thread
        Thread sleepingTread2 = new SleepingTread();
        sleepingTread2.setName("Sleeping thread-2");
        sleepingTread2.start();
        new Thread() {
            public void run() {
                try {
                    System.out.println(ThreadColor.ANSI_BLACK + " anonymous thread running");
                    // timeout is optional, if not provided it will wait indefinitely
                    sleepingTread2.join(2000); // next lines are executed only after this thread finishes
                    System.out.println(ThreadColor.ANSI_BLACK + "anonymous thread running again, post completion/timeout of join method");
                } catch (InterruptedException e){
                    System.out.println(ThreadColor.ANSI_BLACK + "joined method got interrupted");
                }
            }
        }.start();


        System.out.println(ThreadColor.ANSI_BLUE + "After the another thread have started");
    }
}
