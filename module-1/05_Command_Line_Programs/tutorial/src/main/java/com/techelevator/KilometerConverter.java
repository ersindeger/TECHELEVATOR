package com.techelevator;

import java.util.Scanner;

public class KilometerConverter {

    public static void main(String[] args) {   // This will have one MAIN method,
                                            // will take in STRING arguments


        Scanner input = new Scanner(System.in); // the SCANNER class here reads
        // the user's entry from the computer and stores it in variable called INPUT.


        System.out.print("Enter a kilometer value to start at: ");
        // 1. Display a prompt to user to enter something.

        String value = input.nextLine();
        // 2. Use the scanner named "INPUT" to read the STRING the user types..
        // This is assigned to the String which is called "VALUE".

        int kilometerStart = Integer.parseInt(value);
        // 3. Convert STRING "VALUE" into an INT, and store it in a variable called KILOMETERSTART.


        System.out.print("Enter a kilometer value to end with: ");
        value = input.nextLine();
        int kilometerEnd = Integer.parseInt(value);


        System.out.print("How many should it increment by: ");
        value = input.nextLine();
        int incrementBy = Integer.parseInt(value);


        System.out.println("Going from " + kilometerStart + "km to " + kilometerEnd +
                "km in increments of " + incrementBy + "km.");

        for (int km = kilometerStart; km <= kilometerEnd; km += incrementBy) {
//          double miles = km * 0.621371;   //THIS LINE and THE NEXT LINE are functionally identical!!
            double miles = kilometersToMiles(km) ; // calls the method from below!

            System.out.println(km + "km is " + miles + "mi.");
        }


    }

    public static double kilometersToMiles(int kilometers) {
        final double MILES_PER_KILOMETER = 0.621371;
        return kilometers * MILES_PER_KILOMETER;
    }        // This is a method named "KilometersToMiles"... it has a parameter called "Kilometers",
            //  has a CONSTANT called "Miles_Per_Kilometer", and which returns an output as described
            // above

    
}
