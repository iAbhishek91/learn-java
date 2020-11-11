package javaBasics;

import java.util.Scanner;

public class ReadUserInput {
    public static void main(String[] args) {
        // scanner class is used to read inputs from cli just like scanf
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter our age: ");
        int age = 0;
        if (scanner.hasNextInt()) { // validate the input is integer
            age = scanner.nextInt();// converts the input to integer
            scanner.nextLine(); // this is to handle next line char (enter key)
        }
        
        System.out.println("Name is : " + name);
        System.out.println("Age is : " + age);

        scanner.close();
    }
}
