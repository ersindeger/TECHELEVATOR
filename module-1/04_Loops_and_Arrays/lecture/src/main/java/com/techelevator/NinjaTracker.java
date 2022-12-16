package com.techelevator;

public class NinjaTracker {

    public static void main(String[] args)  {

    //declare and represent an array
    String[] ninjaNames= new String[7];

            //be able to put values in an array
        ninjaNames[0] = "Stephanie";
        ninjaNames[1] = "Trae";
        ninjaNames[2] = "Binyam";
        ninjaNames[3] = "Michael";
        ninjaNames[4] = "Istar";
        ninjaNames[5] = "Ian";
        ninjaNames[6] = "Matthew";

        //be able to get the length of the array
        System.out.println("The Length of the array is : " + ninjaNames.length);

        //be able to get data out of an array
        System.out.println("The 5th element contains the ninha : " +  ninjaNames[4]);

        //be able to create arrays of different types
        int numberOfStudents = 18;
        int[] nums = new int[numberOfStudents];
        long[] longNumbers = new long[20];

        //be able to get the 2nd from last element in the array
        String nameAtSecondToLast = ninjaNames[ninjaNames.length - 2];
        System.out.println(nameAtSecondToLast);



        // be able to loop through an array and print out the values
        for (int i = 0; i < ninjaNames.length; i ++) {
//            System.out.println("***" + ninjaNames[i]);
        }



        for (int i = 0; i < ninjaNames.length; i ++) {
            if (ninjaNames[i].equals("Michael")){
                System.out.println("We found Michael at index : " + i);
                break;
            }
            System.out.println("***" + ninjaNames[i]);
        }

        //be able to loop backwards through an array
        for (int i = ninjaNames.length - 1; i >= 0; i --) {
            System.out.println(" CCC " + ninjaNames[i]);
        }


    }








}
