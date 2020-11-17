package javaBasics.lambda;

public class SimpleLambda {
    public static void main(String[] args) {
        // to run a code in thread we need to write may bootstrap code
        (new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Name : " + Thread.currentThread().getName());
            }
        })).start();

        // same code as lambda
        (new Thread(()-> System.out.println("Hello from Lambda."))).start();


        // multi-line body
        (new Thread(()-> {
            System.out.println("This is multiline lambda.");
            System.out.println("Running in: " + Thread.currentThread().getName());
        })).start();
    }
}
