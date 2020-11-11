package challenges;

public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) return -1;
        double oneKmphToMph = 1.609d;

        return Math.round(kilometersPerHour / oneKmphToMph);

    }

    public static void printConversion(double kilometersPerHour) {
        long result = (long) toMilesPerHour(kilometersPerHour);
        if (result < 0 ) System.out.println("Invalid Value");
        else System.out.println(kilometersPerHour + " km/h = " + result + " mi/h");
    }

    public static void main(String[] args) {
        System.out.println(toMilesPerHour(1.5));
        System.out.println(toMilesPerHour(10.25));
        System.out.println(toMilesPerHour(-5.6));
        System.out.println(toMilesPerHour(25.42));
        System.out.println(toMilesPerHour(75.114));

        printConversion(1.5);
        printConversion(-2.0);
        printConversion(95.75);
    }
}
