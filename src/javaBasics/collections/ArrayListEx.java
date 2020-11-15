package javaBasics.collections;

import java.util.ArrayList;

public class ArrayListEx {
    // NOTE: Arraylist takes objects, primitive types are not allowed
    // NOT allowed: ArrayList<int> intValue = new ArrayList<int>();
    // For that either wrap the primitive type within a class. or use wrapper class
    // ArrayList<Integer> intValue = new ArrayList<Integer>();
    // int.Value.add(Integer.valueOf(6))
    private ArrayList<String> groceryList;

    public ArrayListEx(ArrayList<String> groceryList) {
        this.groceryList = groceryList;
    }

    public void addItemToGroceryList(String item) {
        this.groceryList.add(item);
    }

    public void removeItemFromGroceryList(String item) {
        this.groceryList.remove(item);
    }

    public void updateItemInGroceryList(String itemToUpdate, String newValue) {
        int index = this.groceryList.indexOf(itemToUpdate);
        if (index >= 0) {
            this.groceryList.set(index, newValue);
        }
    }

    public boolean searchGroceryList (String item) {
        return this.groceryList.contains(item);
    }

    public void printGroceryList () {
        for(int i = 0; i < groceryList.size(); i++) {
            System.out.println(i + ". " + this.groceryList.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<String>();
        ArrayListEx myArrLs = new ArrayListEx(groceryList);

        myArrLs.addItemToGroceryList("Rice");
        myArrLs.addItemToGroceryList("Oil");
        myArrLs.addItemToGroceryList("Ground nut");
        myArrLs.addItemToGroceryList("Neem");
        myArrLs.printGroceryList();
        System.out.println("Neem exists ? " + myArrLs.searchGroceryList("Neem"));
        myArrLs.removeItemFromGroceryList("Oil");
        myArrLs.printGroceryList();
        myArrLs.updateItemInGroceryList("Ground nut", "badam");
        myArrLs.printGroceryList();
    }
}

