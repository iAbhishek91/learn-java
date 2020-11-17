package challenges.producerconsumer.usingconcurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import static challenges.producerconsumer.usingconcurrent.TreadColor.*;

public class MultipleProducerConsumerMQThreadPool {
    public static void main(String[] args) {
        // purposefully using ArrayList as they are NOT thread safe
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        // interface to implement thread pool

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer2 producer1 = new MyProducer2(buffer, ANSI_GREEN, bufferLock);
        executorService.execute(producer1);

        MyProducer2 producer2 = new MyProducer2(buffer, ANSI_BLACK, bufferLock);
        executorService.execute(producer2);

        MyProducer2 producer3 = new MyProducer2(buffer, ANSI_BLUE, bufferLock);
        executorService.execute(producer3);

        MyConsumer2 consumer1 = new MyConsumer2(buffer, ANSI_PURPLE, bufferLock);
        executorService.execute(consumer1);

        MyConsumer2 consumer2 = new MyConsumer2(buffer, ANSI_CYAN, bufferLock);
        executorService.execute(consumer2);

        // need to manually shutdown the service
        // shutdown once all the thread have completed.
        // in this example it will never..
        executorService.shutdown();
    }
}


class MyProducer2 implements Runnable {
    private final List<String> buffer;
    private final String color;
    private final ReentrantLock bufferLock;

    public MyProducer2(List<String> buffer, String color, ReentrantLock bufferLock) {
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


class MyConsumer2 implements Runnable {
    private final List<String> buffer;
    private final String color;
    private final ReentrantLock bufferLock;

    public MyConsumer2(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while(true) {
            bufferLock.lock();
            try {
                if (buffer.isEmpty() || buffer.get(0).equals("EOF")) {
                    continue;
                }
                // always consuming from position 0
                System.out.println(color + "Removing..." + buffer.remove(0) + " by " + Thread.currentThread().getName());

            } finally {
                bufferLock.unlock();
            }
        }
    }
}