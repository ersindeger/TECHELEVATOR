package com.techelevator;

import java.util.List;
import java.util.Scanner;

public class UI {

    private Scanner myScanner = new Scanner(System.in);


    public int printMenu() {

        System.out.println("******** EVIL VINNY'S REAL ESTATE EMPIRE *************\n");

        System.out.println("1. Fetch A List Of Homes");
        System.out.println("2. Search For A Home By MLS ID");
        System.out.println("3. Add Home");
        System.out.println("4. Delete Home");
        System.out.println("5. Exit");

        System.out.println("Please select an option above --> \n\n");

        String answer = myScanner.nextLine();
        return  Integer.parseInt(answer);


    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printHomes(List<Home> homes) {

        for (Home home : homes) {


            System.out.println(home.getMlsId() + " has a price of " + home.getPrice() + " " + home.getNumberOfBedrooms()
                    + " bedrooms" + " and was located at " + home.getAddress().getCity());
        }



    }

    public String askForMLSId() {

        System.out.println("Please enter the mls id:");
        return myScanner.nextLine();
    }

    public void printHome(String mlsId, Home home) {

        if (home == null) {
            System.out.println("***  Home " + mlsId + " was not found. Please try again!");
            return;
        }

        System.out.println("********  Home Found *******");
        System.out.println("MLSID: " + home.getMlsId());
        System.out.println("Bedrooms: " + home.getNumberOfBedrooms());
        System.out.println("Square Feet: " + home.getSquareFeet());

        if (home.getAddress() != null) {
            System.out.println("Street Address: " + home.getAddress().getStreetNumber() + " " + home.getAddress().getStreetName() );
            System.out.println("City: " + home.getAddress().getCity() + ", " + home.getAddress().getState() + " " + home.getAddress().getZipCode() );
        }


        if (home instanceof OwnedHome) {
            System.out.println("Owned Home: Additional Information");
            System.out.println("Has HOA? " + ((OwnedHome) home).isHasHOA());
            return;
        }

        if (home instanceof RentalHome) {
            System.out.println("Rental: Additional Information");
            System.out.println("Rental Price: " + ((RentalHome) home).getMonthlyRent());
        }





    }





}
