package challenges.inheritance;

public class Main {
    public static void main(String[] args) {
        Audi abhisAudi = new Audi("Blue",  "Sedan", "A4", 250);

        abhisAudi.changingGear(1);
        abhisAudi.dashboard();

        abhisAudi.changingGear(2);
        abhisAudi.dashboard();

        abhisAudi.changingGear(4);
        abhisAudi.dashboard();

        abhisAudi.changingGear(6);
        abhisAudi.dashboard();

        abhisAudi.changingGear(2);
        abhisAudi.dashboard();

        abhisAudi.changingGear(3);
        abhisAudi.dashboard();
    }
}
