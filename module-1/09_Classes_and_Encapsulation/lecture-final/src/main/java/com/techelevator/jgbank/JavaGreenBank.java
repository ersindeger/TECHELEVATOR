package com.techelevator.jgbank;

public class JavaGreenBank {


    public static void main(String[] args) {

        SavingsAccount mySavings = new SavingsAccount(100.00, "1234");
        mySavings.setFirstName("Osman");
        mySavings.setLastName("B");


        System.out.println(mySavings.getBalance());
        mySavings.deposit(100.00);
        System.out.println(mySavings.getBalance());
        System.out.println(mySavings.getFirstName() + " " + mySavings.getLastName());
        System.out.println(mySavings.getFullName());


        // now let's withdraw 50

        SavingsAccount yourSavings = new SavingsAccount("4567");
        System.out.println("");



    }
}
