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





}
