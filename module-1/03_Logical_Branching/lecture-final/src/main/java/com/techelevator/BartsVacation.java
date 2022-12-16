package com.techelevator;

import java.util.Scanner;

public class BartsVacation {

    public static void main(String[] args) {

        // declare and initialize a scanner that listens to the keyboard
        Scanner keyboardScanner = new Scanner(System.in);


        boolean AreWeThereYet = false;

        while (!AreWeThereYet) {


            System.out.println("Are we there yet? (Y)es or (N)o");
            String answer = keyboardScanner.nextLine();

            if (answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y")) {
                System.out.println("Cowabunga!");
                AreWeThereYet = true;
            } else {
                System.out.println("Eat my shorts!");
            }

            System.out.println("Exiting the program");
        }










    }

















}
