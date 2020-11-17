package javaBasics.concurrency.concurrent;

import java.util.concurrent.*;

public class MyCallable {
    public static void main(String[] args) {
        // value is returned as a object of type future
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // result of asynchronous code block
        Future future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("call method is executed");
                return "return from asynchronous code";
            }
        });

        // to access the result call future.get
        // future.get() when called from main thread
        // it blocks the main thread until the result is available
        // very similar to async and await in js
        // this are helpful when we need to get back some result form thread.
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            System.out.println("Error while fetching data from async code");
        }

        // stop the executor
        executorService.shutdown();
    }
}
