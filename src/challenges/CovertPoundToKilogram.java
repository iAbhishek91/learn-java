package challenges;


// 1 pound is equal to 0.45359237
public class CovertPoundToKilogram {

    public static void main(String[] args) {
        double POUND_TO_KG = 0.45359237d;
        double inputInPound = 10d;
        double resultInKilogram = inputInPound * POUND_TO_KG;

        System.out.println(resultInKilogram);
    }
}
