package javaBasics.generics.multipleBound;

// Number is a abstract class implemented by Integer, Double, Float
public class MultipleBound<T1 extends Number, T2 extends String> {
    private final T1 a;
    private final T1 b;
    private T2 result;

    public MultipleBound(T1 a, T1 b) {
        this.a = a;
        this.b = b;
    }

    public void add() {
        // cast value of a & b to double
        double result1 = ((double)a.intValue() + (double)b.intValue());

        // cast result to string and back to T2
        this.result = (T2)String.valueOf(result1);
    }

    public T2 getResult() {
        return result;
    }
}
