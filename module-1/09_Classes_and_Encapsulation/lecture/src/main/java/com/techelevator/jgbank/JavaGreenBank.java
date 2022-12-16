package com.techelevator.jgbank;

public class JavaGreenBank {

    public static void main(String[] args) {

        SavingsAccount mySavings = new SavingsAccount();
        mySavings.setAccountNumber("123456");
        mySavings.setFirstName("Osman");
        mySavings.setLastName("Burgazli");


        System.out.println (mySavings.getBalance());

        mySavings.deposit(100.00);

        System.out.println (mySavings.getBalance());
        System.out.println();


    }
}
