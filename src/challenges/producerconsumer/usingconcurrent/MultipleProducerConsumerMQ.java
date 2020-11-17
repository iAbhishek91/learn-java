package challenges.producerconsumer.usingconcurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static challenges.producerconsumer.usingconcurrent.TreadColor.*;

public class MultipleProducerConsumerMQ {
    public static void main(String[] args) {
        // purposefully using ArrayList as they are NOT thread safe
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        Thread producer1 = new Thread(new MyProducer2(buffer, ANSI_GREEN, bufferLock));
        producer1.setName("Producer-1");
        producer1.start();

        Thread producer2 = new Thread(new MyProducer2(buffer, ANSI_GREEN, bufferLock));
        producer2.setName("Producer-2");
        producer2.start();

        Thread producer3 = new Thread(new MyProducer2(buffer, ANSI_GREEN, bufferLock));
        producer3.setName("Producer-3");
        producer3.start();

        Thread consumer1 = new Thread(new MyConsumer2(buffer, ANSI_PURPLE, bufferLock));
        consumer1.setName("Consumer-1");
        consumer1.start();

        Thread consumer2 = new Thread(new MyConsumer2(buffer, ANSI_CYAN, bufferLock));
        consumer2.setName("Consumer-2");
        consumer2.start();
    }
}


class MyProducer implements Runnable {
    private final List<String> buffer;
    private final String color;
    private final ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
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
            buffer.add(item);
            bufferLock.unlock();
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException ie) {
                System.out.println(color + Thread.currentThread().getName() + " was interrupted");
            }
        }

        bufferLock.lock(); // dev are responsible for acquiring the locking
        buffer.add("EOF");
        bufferLock.unlock(); // dev are responsible for releasing the lock

        System.out.println(color + Thread.currentThread().getName() +" exiting...");
    }
}


class MyConsumer implements Runnable {
    private final List<String> buffer;
    private final String color;
    private final ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while(true) {
            bufferLock.lock();
            if (buffer.isEmpty() || buffer.get(0).equals("EOF")) {
                bufferLock.unlock();
                continue;
            } else {
                // this is crazy, locks all over
                // however, this is not the recommended way of using locks,
                // we should always unlock in finally block
                // Hence, all the critical section should be within try catch
                bufferLock.unlock();
                bufferLock.lock();
                // always consuming from position 0
                System.out.println(color + "Removing..." + buffer.remove(0) + " by " + Thread.currentThread().getName());
                bufferLock.unlock();
            }
        }
    }
}