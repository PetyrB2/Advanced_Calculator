package com.qa.app;

import java.util.Scanner;

public class mainApplication {

    public static void main(String[] args) {
        // Set up scanner object
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

        // Read an int from the user
        System.out.println("Please enter a number: ");
        int first = scan.nextInt();    

        // Read second int from the user
        System.out.println("Please enter a Second number: ");
        int second = scan.nextInt();    

        // Print the responses
        System.out.println("------------------------");
        System.out.println("");
        System.out.println("First Value = " + first);
        System.out.println("Second Value = " + second);
        System.out.println("");
        System.out.println("------------------------");
        System.out.println("");
        System.out.println("Addition of the Two Values:");
        System.out.println("\t" + (first+second));
        System.out.println("");
        System.out.println("Subtraction of Second Value from the First: ");
        System.out.println("\t" + (first-second));
        System.out.println("");
        System.out.println("Multiplication of the Two Values: ");
        System.out.println("\t" + (first*second));
        System.out.println("");
        System.out.println("Division of the Two Values: ");
        System.out.println("\t" + (first/second));
        System.out.println("");
        System.out.println("*********************************");
    }
}
