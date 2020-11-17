package challenges.producerconsumer.usingconcurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static challenges.producerconsumer.usingconcurrent.TreadColor.*;

public class MultipleProducerConsumerMQWithBestPractice {
    public static void main(String[] args) {
        // purposefully using ArrayList as they are NOT thread safe
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        Thread producer1 = new Thread(new MyProducer1(buffer, ANSI_GREEN, bufferLock));
        producer1.setName("Producer-1");
        producer1.start();

        Thread producer2 = new Thread(new MyProducer1(buffer, ANSI_GREEN, bufferLock));
        producer2.setName("Producer-2");
        producer2.start();

        Thread producer3 = new Thread(new MyProducer1(buffer, ANSI_GREEN, bufferLock));
        producer3.setName("Producer-3");
        producer3.start();

        Thread consumer1 = new Thread(new MyConsumer1(buffer, ANSI_PURPLE, bufferLock));
        consumer1.setName("Consumer-1");
        consumer1.start();

        Thread consumer2 = new Thread(new MyConsumer1(buffer, ANSI_CYAN, bufferLock));
        consumer2.setName("Consumer-2");
        consumer2.start();
    }
}


class MyProducer1 implements Runnable {
    private final List<String> buffer;
    private final String color;
    private final ReentrantLock bufferLock;

    public MyProducer1(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] itemsToAdd = {"1", "2", "3", "4", "5"};

        for (String item : itemsToAdd) {
            System.out.println(color + "Adding..." + item + " by " + Thread.currentThread().getName());
            bufferLock.lock();
            try {
                buffer.add(item);
            } finally {
                bufferLock.unlock();
            }
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException ie) {
                System.out.println(color + Thread.currentThread().getName() + " was interrupted");
            }
        }

        // Best practice
        // lock it outside the try catch
        // critical code in try
        // release the lock in finally
        bufferLock.lock(); // dev are responsible for acquiring the locking
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock(); // dev are responsible for releasing the lock
        }


        System.out.println(color + Thread.currentThread().getName() +" exiting...");
    }
}


class MyConsumer1 implements Runnable {
    private final List<String> buffer;
    private final String color;
    private final ReentrantLock bufferLock;

    public MyConsumer1(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        long counter=0;
        while(true) {
            // acquires the lock, if not held by others
            if(bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty() || buffer.get(0).equals("EOF")) {
                        continue;
                    }
                    System.out.println(color  + "The counter: " + counter);
                    counter = 0;
                    // always consuming from position 0
                    System.out.println(color + "Removing..." + buffer.remove(0) + " by " + Thread.currentThread().getName());
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }
        }
    }
}