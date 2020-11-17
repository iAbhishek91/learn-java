package challenges.producerconsumer.usingtread;

import java.util.Random;

// Multi thread problem
// deadlock scenario
// thread communication
public class ReadWrite {
    public static void main(String[] args) {
        Message mq = new Message();

        Thread writerThread = new Thread(new Writer(mq));
        writerThread.setName("Writer");
        writerThread.start();
        Thread readThread = new Thread(new Reader(mq));
        readThread.setName("Reader");
        readThread.start();
    }
}


// How deadlock is created:
// while loop can be infinite if reader thread calls read() method when queue is empty
// also when writer thread  calls the write() method when queue is not empty.
// If any of the thread go to infinite loop, the other thread will starve to get resources.
// This will create a deadlock scenario.
// INTRODUCING WAIT and NOTIFYALL
// so to avoid the infinite loop, wait() will make the loop wait and break the loop and notify other thread to start
class Message {
    private String message;
    private boolean qEmpty = true;

    public synchronized String read() {
        System.out.println("Read: qEmpty: " + qEmpty + "; from thread: " + Thread.currentThread().getName());
        while(qEmpty) {
            try {
                wait();
                System.out.println("Read: waiting: " + Thread.currentThread().getName());
            } catch (InterruptedException ie) {

            }
        }
        qEmpty = true;
        System.out.println("Read: qEmpty: " + qEmpty + "; from thread: " + Thread.currentThread().getName());
        notifyAll();
        return message;
    }

    public synchronized  void write(String msg) {
        System.out.println("Write: qEmpty: " + qEmpty + "; from thread: " + Thread.currentThread().getName());
        while(!qEmpty) {
            try {
                wait(); // should always be in a loop
                System.out.println("Write: waiting: " + Thread.currentThread().getName());
            } catch (InterruptedException ie) {

            }
        }
        qEmpty = false;
        message = msg;
        System.out.println("Write: qEmpty: " + qEmpty + "; from thread: " + Thread.currentThread().getName());
        notifyAll();
    }
}


class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {"abhishek", "ferrari", "mars", "lava"};
        Random random = new Random();

        for (String msg : messages) {
            message.write(msg);
            try {
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException ie) {
                System.out.println("Write thread is interrupted");
            }
        }

        message.write("Done!");
    }
}

class Reader implements Runnable {
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(String msg = message.read(); !msg.equals("Done!"); msg = message.read()) {
            System.out.println(msg);
            try {
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException ie)  {
                System.out.println("Read thread in interrupted");
            }
        }
    }
}