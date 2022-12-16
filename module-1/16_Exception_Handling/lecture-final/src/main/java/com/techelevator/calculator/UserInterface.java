package com.techelevator.calculator;

import java.util.Scanner;

public class UserInterface {

    private Scanner myScanner = new Scanner(System.in);


    public Numbers getNumbers() {

        Numbers nums = new Numbers();
        System.out.println("Please enter number 1: ");

        int num1 = myScanner.nextInt();
        myScanner.nextLine();

        System.out.println("Please enter number 2: ");
        int num2 = myScanner.nextInt();
        myScanner.nextLine();

        nums.setNum1(num1);
        nums.setNum2(num2);

        return nums;
    }


    public void printMessage(String msg) {
        System.out.println(msg);
    }


}
