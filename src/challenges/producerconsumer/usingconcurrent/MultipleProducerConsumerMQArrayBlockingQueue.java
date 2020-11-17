package challenges.producerconsumer.usingconcurrent;

import javaBasics.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import static challenges.producerconsumer.usingconcurrent.TreadColor.*;

public class MultipleProducerConsumerMQArrayBlockingQueue {
    public static void main(String[] args) {
        // ArrayBlockingQueue implements BlockingQueue interface.
        // Blocking queue are queue which makes read process to wait until values are available
        // also, for write process wait until space is free.

        // ArrayBlockingQueue
        // they are bounded, means it should have size.
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer3 producer1 = new MyProducer3(buffer, ANSI_GREEN);
        executorService.execute(producer1);

        MyProducer3 producer2 = new MyProducer3(buffer, ANSI_GREEN);
        executorService.execute(producer2);

        MyProducer3 producer3 = new MyProducer3(buffer, ANSI_GREEN);
        executorService.execute(producer3);

        MyConsumer3 consumer1 = new MyConsumer3(buffer, ANSI_PURPLE);
        executorService.execute(consumer1);

        MyConsumer3 consumer2 = new MyConsumer3(buffer, ANSI_CYAN);
        executorService.execute(consumer2);
    }
}


class MyProducer3 implements Runnable {
    private final ArrayBlockingQueue<String> buffer;
    private final String color;

    public MyProducer3(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] itemsToAdd = {"1", "2", "3", "4", "5"};

        for (String item : itemsToAdd) {
            try {
                System.out.println(color + "Adding..." + item + " by " + Thread.currentThread().getName());
                buffer.put(item);
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException ie) {
                System.out.println(color + Thread.currentThread().getName() + " thread was interrupted");
            }
        }

        try {
            buffer.put("EOF");
        } catch (InterruptedException ie) {
            System.out.println(color + Thread.currentThread().getName() + " thread was interrupted.");
        }

        System.out.println(color + Thread.currentThread().getName() +" exiting...");
    }
}


class MyConsumer3 implements Runnable {
    private final ArrayBlockingQueue<String> buffer;
    private final String color;

    public MyConsumer3(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (buffer) {
                try {
                    // Questions???
                    // why there is NO index on the peek and take method???
                    // in ArrayBlockingQueue its not required
                    // as in queue the read and writes are done from specific position in FIFO order.

                    // why null pointer exp is thrown, when ArrayBlockingQueue is thread safe???
                    // This is because there are suspension point between "peek()" and "take()"
                    // The error will occur intermittently.
                    // to get rid of the err, we put all our code in synchronize class
                    if (buffer.isEmpty() || buffer.peek().equals("EOF")) {
                        continue;
                    }
                    System.out.println(color + "Removing..." + buffer.take() + " by " + Thread.currentThread().getName());
                } catch (InterruptedException ie) {
                    System.out.println(color + Thread.currentThread().getName() + " thread was interrupted.");
                }
            }
        }
    }
}