package com.techelevator.bank;

public class CheckingAccount extends Account{

    private boolean isInterestBearing;


    @Override
    public void printStatement() {
        System.out.println("Checking Statement:" + getAccountNumber() + ", " + getBalance() + " and earns interest is " + isInterestBearing);
    }

    public boolean isInterestBearing() {
        return isInterestBearing;
    }

    public void setInterestBearing(boolean interestBearing) {
        isInterestBearing = interestBearing;
    }
}
