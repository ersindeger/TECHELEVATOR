package com.techelevator;


import java.util.Scanner;

public class HumanAgeInDogYears {


    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);


        /**************** Example 1 nextLine() ****************/
//        System.out.println("How old are you human?");
//        String age = myScanner.nextLine();
//        //System.out.println(age);
//
//        int ageAsInt = Integer.parseInt(age);   // convert String age into an int
//
//        int ageInDogYears = ageAsInt * 7;
//        System.out.println("Human Age " + age + " is equal to " + ageInDogYears + " in dog years");

        /**************** Example 2 nextInt() ****************/

//        System.out.println("How old are you human?");
//        int age = myScanner.nextInt();
//        myScanner.nextLine();      // eats up the extra newline character
//
//
//        System.out.println("What is your favorite book?");
//        String book = myScanner.nextLine();
//
//        System.out.println("Done");

        /**************** Example 3 - Comma Separated input  ****************/
        System.out.println("Enter a series of human ages, separated by comma?");
        String values = myScanner.nextLine();
        System.out.println(values);

        String[] humanAges = values.split(",");

        for (int i=0; i< humanAges.length; i++) {
           //calculate and print the human age in dog years for each element in the array
           String tempValue = humanAges[i];
           int valueAsInt = Integer.parseInt(tempValue);
            System.out.println("Human Age: " + tempValue + ", Dog Years: " + valueAsInt * 7);

        }




    }



}
