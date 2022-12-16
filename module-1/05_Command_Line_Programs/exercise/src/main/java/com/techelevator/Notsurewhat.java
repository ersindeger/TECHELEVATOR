package com.techelevator;

import java.util.Random;

public class Notsurewhat {

    public static void main(String[] args) {
        System.out.println();


        for (int i = 0; i < 7; i++) {
            Random r = new Random();
            int distance = r.nextInt(230) + 10; //generates a random number between 10 & 240

            System.out.println(distance);
        }


    }
}
