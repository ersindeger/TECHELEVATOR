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

             printHome(home);

        }



    }

    public String askForMLSId() {

        System.out.println("Please enter the mls id:");
        return myScanner.nextLine();
    }

    public void printHome(Home home) {

        System.out.println("***************************************************************");
        System.out.println("\nMLS Number: " + home.getMlsId());

        if (home.getAddress() != null) {
            System.out.println("Street Address: "
                    + home.getAddress().getAddressLine1() + " "
                    + home.getAddress().getCity() + " "
                    + home.getAddress().getState() + " "
                    + home.getAddress().getZip() + "\n");
        }

        System.out.println(String.format("%-25s %s", "Bedrooms: ", home.getNumberOfBedrooms()));
        System.out.println(String.format("%-25s %s", "Bathrooms: ", home.getNumberOfBathrooms()));
        System.out.println(String.format("%-25s %s", "Square Feet: ", home.getSquareFeet()));
        System.out.println(String.format("%-25s $%s", "Price: ", String.format("%.2f", home.getListingPrice())));
        System.out.println("\nDescription: " + home.getDescription());

        if (home instanceof OwnedHome) {
            System.out.println("\nAdditional Information For Owned Home");
            System.out.println("Has HOA? " + ((OwnedHome) home).isHasHOA());
            return;
        }

        if (home instanceof RentalHome) {
            System.out.println("\nAdditional Information For Rental");
            System.out.println("Rental Price: " + ((RentalHome) home).getMonthlyRent());
        }

    }


}
