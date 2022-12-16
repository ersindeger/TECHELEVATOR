package com.techelevator;

import java.util.Scanner;


public class HumanAgeInDogYears {


    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);


        /******************** Example 1  nextLine  ****************/
//        System.out.println("How old are you, dear human?");
//        String age = myScanner.nextLine();
//        System.out.println(age);
//
//        int ageAsInt =  Integer.parseInt(age);  //converts String age into an int
//
//        int ageInDogYears = ageAsInt * 7 ;
//        System.out.println("Age " + age + " is equal to " + ageInDogYears + "  in dog years" );

        // note: we did NOT need to introduce a new variable above ageAsInt...
        // it could have been done without it directly....



        /******************** Example 2 nextInt() ****************/

//        System.out.println("How old are you, human?!?");
//        int age = myScanner.nextInt();
//        myScanner.nextLine();    //eats up the extra new line char (enter char \n )
//                                 // that would prematurely finish the program
//                                // before answering the NEXT question in line below....
//
//
//        System.out.println("What is your favorite book?");
//        String book = myScanner.nextLine();
//
//        System.out.println("Done!!");
//


        /****************** Example 3  - Comma Separated input ******************/

        System.out.println("Enter a series of human ages, separated by commas please!");
        String values = myScanner.nextLine();
        System.out.println(values);

        String[] humanAges = values.split( ",");

//        String[] humanAges = values.split( "\\|");

        // huge help for your capstone project RIGHT above WITH THE COMMENT LINE!!!

        for (int i=0; i < humanAges.length; i ++) {
            //calculate and print the human age in dog years for each element in the array
            String tempValue = humanAges[i];
            int valueAsInt = Integer.parseInt(tempValue);
                System.out.println("Human age:  " + tempValue + ", Dog years:  " +  valueAsInt * 7);

//            System.out.println(humanAges[i]);
        }

    }



}
