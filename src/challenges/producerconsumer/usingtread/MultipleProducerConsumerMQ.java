package challenges.producerconsumer.usingtread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static challenges.producerconsumer.usingconcurrent.TreadColor.*;

public class MultipleProducerConsumerMQ {
    public static void main(String[] args) {
        // purposefully using ArrayList as they are NOT thread safe
        List<String> buffer = new ArrayList<>();
        Thread producer1 = new Thread(new MyProducer(buffer, ANSI_GREEN));
        producer1.setName("Producer-1");
        producer1.start();

        Thread producer2 = new Thread(new MyProducer(buffer, ANSI_GREEN));
        producer2.setName("Producer-2");
        producer2.start();

        Thread producer3 = new Thread(new MyProducer(buffer, ANSI_GREEN));
        producer3.setName("Producer-3");
        producer3.start();

        Thread consumer1 = new Thread(new MyConsumer(buffer, ANSI_PURPLE));
        consumer1.setName("Consumer-1");
        consumer1.start();

        Thread consumer2 = new Thread(new MyConsumer(buffer, ANSI_CYAN));
        consumer2.setName("Consumer-2");
        consumer2.start();
    }
}


class MyProducer implements Runnable {
    private final List<String> buffer;
    private final String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] itemsToAdd = {"1", "2", "3", "4", "5"};

        for (String item : itemsToAdd) {
            System.out.println(color + "Adding..." + item + " by " + Thread.currentThread().getName());
            synchronized (buffer) {
                buffer.add(item);
            }
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException ie) {
                System.out.println(color + Thread.currentThread().getName() + " was interrupted");
            }
        }

        synchronized (buffer) {
            buffer.add("EOF");
        }
        System.out.println(color + Thread.currentThread().getName() +" exiting...");
    }
}


class MyConsumer implements Runnable {
    private final List<String> buffer;
    private final String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (buffer) {
                if (buffer.isEmpty() || buffer.get(0).equals("EOF")) {
                    continue;
//                } else if (buffer.get(0).equals("EOF")) {
//                    // we don't remove the EOF
//                    System.out.println(color + Thread.currentThread().getName() + " exiting...");
//                    break;
                } else {
                    // always consuming from position 0
                    System.out.println(color + "Removing..." + buffer.remove(0) + " by " + Thread.currentThread().getName());
                }
            }
        }
    }
}