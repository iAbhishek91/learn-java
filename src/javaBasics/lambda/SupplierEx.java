package javaBasics.lambda;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierEx {
    public static void main(String[] args) {
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(600);

        for (int i = 0; i < 10; i += 1) {
            System.out.println(randomSupplier.get());
        }
    }
}
