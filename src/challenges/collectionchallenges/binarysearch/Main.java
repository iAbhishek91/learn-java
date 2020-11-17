package challenges.collectionchallenges.binarysearch;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Mercedes", 2);
        car.printSeat();
        car.reserveSeat("A03");
        car.reserveSeat("A03");
        car.reserveSeat("B03");
        car.printSeat();
        car.cancelReservation("A03");
        car.cancelReservation("A03");
        car.printSeat();
        System.out.println(car.findSeatBinary("A"));
        System.out.println(car.findSeatBinary("B01"));
        car.reserveSeatUsingBinarySearch("A01");
        car.reserveSeatUsingBinarySearch("A02");
        car.cancelReservationUsingBinarySearch("A02");
        car.printSeat();
    }
}
