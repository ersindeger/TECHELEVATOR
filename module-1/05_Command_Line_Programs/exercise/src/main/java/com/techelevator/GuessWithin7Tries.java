package com.techelevator;

import java.util.Random;
import java.util.Scanner;

public class GuessWithin7Tries {

    public static void main(String[] args) {

        Random r = new Random();
        int number = r.nextInt(99) + 1;


        Scanner myScanner = new Scanner(System.in); // call in Scanner to read user input.


        System.out.print("I have picked a number between 1 & 99... Let's see how many tries" +
                "it will take you to find the number I picked... Enter your guess now: ");

        int i = 1; //counter
        int guess = Integer.parseInt(myScanner.nextLine());

        if (number == guess) {
            System.out.println("that is incredible! you literally knew it in ONE try!!!");
        }


        while (guess != number) {

            if (number < guess){
                System.out.println(" Go lower!! Make another guess?!");
                guess = Integer.parseInt(myScanner.nextLine());
            }
            else{
                System.out.println(" Go higher! Make another guess!");
                guess = Integer.parseInt(myScanner.nextLine());
            }
            i = i + 1;
        }

        System.out.println();
        System.out.println("YES!!! The number I picked was " + guess +  "." + " You knew it in  " + i + " tries... Thanks!!");




    }


}
