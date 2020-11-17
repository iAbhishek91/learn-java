package challenges.collectionchallenges.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Car {
    private final String name;
    private List<Seat> seats = new ArrayList<>();


    public Car(String name, int noOfRows) {
        this.name = name;
        int lastRow = 'A' + noOfRows;
        for(char row='A'; row < lastRow; row++) {
            System.out.println(row);
            for (int column=1; column <= 3; column++) {
                String formattedColumn = String.format("%02d", column);
                seats.add(new Seat(row + formattedColumn));
            }
        }
    }


    private Seat findSeat(String seatNo) {
        for(Seat seat:seats) {
            System.out.print(".");
            if(seat.seatNo.equals(seatNo)) { return seat; }
        }
        return null;
    }


    public Seat findSeatBinary(String seatNo) {
        Seat seat = new Seat(seatNo);
        // search seat on seat list
        int searchResult = Collections.binarySearch(seats, seat);
        if(searchResult == -1) { return null; }
        return seats.get(searchResult);
    }


    public void printSeat() {
        for(Seat seat:seats) {
            System.out.println(seat.seatNo + " - " + seat.isOccupied);
        }
    }


    public void reserveSeat(String seatNo) {
        Seat seat = findSeat(seatNo);
        if (seat != null && !seat.isOccupied) {
            seat.setOccupied(true);
            return;
        }
        System.out.println(seatNo + " seat do not exits or is already taken!");
    }


    public void cancelReservation(String seatNo) {
        Seat seat = findSeat(seatNo);
        if (seat != null && seat.isOccupied) {
            seat.setOccupied(false);
            return;
        }
        System.out.println(seatNo + " seat do not exits or is not booked!");
    }


    public void reserveSeatUsingBinarySearch(String seatNo) {
        Seat seat = findSeatBinary(seatNo);
        if (seat != null && !seat.isOccupied) {
            seat.setOccupied(true);
            return;
        }
        System.out.println(seatNo + " seat do not exits or is already taken!");
    }


    public void cancelReservationUsingBinarySearch(String seatNo) {
        Seat seat = findSeatBinary(seatNo);
        if (seat != null && seat.isOccupied) {
            seat.setOccupied(false);
            return;
        }
        System.out.println(seatNo + " seat do not exits or is not booked!");
    }


    private class Seat implements Comparable<Seat> {
        private final String seatNo;
        private Boolean isOccupied = false;

        public Seat(String seatNo) {
            this.seatNo = seatNo;
        }

        public void setOccupied(Boolean occupied) {
            isOccupied = occupied;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNo.compareToIgnoreCase(seat.seatNo);
        }
    }
}
