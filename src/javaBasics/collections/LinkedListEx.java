package javaBasics.collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListEx {
    public static void main(String[] args) {
        LinkedList<String> places = new LinkedList<>();
        LinkedList<String> placesOrdered = new LinkedList<>();
        places.add("East Ham");
        places.add("Upton park");
        places.add("Plaistow");
        places.add("West Ham");
        places.add("Bow Road");
        places.add("Bromley by Bow");
        places.add("Mile End");
        places.add("Stephine Green");
        places.add("WhiteChapel");
        places.add("AldGate East");
        places.add("Monument");
        places.add("BlackFires");
        places.add("Temple");
        places.add("Embankment");
        places.add("WestMinister");

        displayLinkedList(places);
        removeLinkedList(places, "WestMinister");
        displayLinkedList(places);

        addItemInOrder(placesOrdered, "Stradford");
        addItemInOrder(placesOrdered, "Stradford");
        addItemInOrder(placesOrdered, "West Ham");
        addItemInOrder(placesOrdered, "City of London");
        addItemInOrder(placesOrdered, "North Greenwich");
        addItemInOrder(placesOrdered, "Canary Wharf");
        addItemInOrder(placesOrdered, "Canada Water");
        addItemInOrder(placesOrdered, "Bermonsey");
        addItemInOrder(placesOrdered, "London Bridge");

        displayLinkedList(placesOrdered);
    }

    private static void displayLinkedList(LinkedList<String> ll){
        // unlike listIterator, iterator is not doubly link list.
        Iterator<String> iterator = ll.iterator();
        while(iterator.hasNext()) {
            System.out.println("District line now stops at: " + iterator.next());
        }

        // can also be written as
//        for(String stop:ll) {
//            System.out.println("District line stops at: " + stop);
//        }
        System.out.println("=============================");
    }

    private static void removeLinkedList(LinkedList<String> ll, String place) {
        if (ll.contains(place)) {
            ll.remove(place);
            return;
        }
        System.out.println("Item do not exists");
    }

    private static void addItemInOrder(LinkedList<String> ll, String place) {
        // list iterator creates a doubly link list for traversal
        ListIterator<String> listIterator = ll.listIterator();

        while(listIterator.hasNext()) {
            int comparisionResult = listIterator.next().compareTo(place);

            if (comparisionResult == 0) {
                // string is equal to argument
                System.out.println(place + " - Item already exits");
                return;
            } else if (comparisionResult > 0) {
                // string is greater than argument
                listIterator.previous();
                listIterator.add(place);
                return;
            } else {
                // string is less than argument
                // do nothing
            }
        }
        listIterator.add(place);
    }
}
