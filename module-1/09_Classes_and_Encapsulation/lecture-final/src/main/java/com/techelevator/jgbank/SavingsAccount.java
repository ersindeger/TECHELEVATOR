package com.techelevator.jgbank;

public class SavingsAccount {

    // member or class or instance variable
    private double balance;
    private String accountNumber;
    private String firstName;
    private String lastName;

//    public SavingsAccount(double openingBalance) {
//        this.balance = openingBalance;
//    }

    public SavingsAccount(double openingBalance, String accountNumber) {
        this.balance = openingBalance;
        this.accountNumber = accountNumber;

    }

    public SavingsAccount(String accountNumber) {
        this.balance = 0;
        this.accountNumber = accountNumber;
    }

    public SavingsAccount() {

    }




    // deposit method
    public void deposit(double amountToDeposit) {

        if (amountToDeposit > 0) {
            this.balance = this.balance + amountToDeposit;    // this.balance += amountToDeposit
        }
    }

    public void withdraw(double amountToWithdraw ) {

        //validate they have enough money in their account
        if (isValidWithdraw(amountToWithdraw)) {
            this.balance = this.balance - amountToWithdraw;
        }

    }

    private boolean isValidWithdraw(double amountToWithdraw) {

        if (this.balance - amountToWithdraw > 0) {
            return true;
        }
        return false;
    }


    //derived property
    public String getFullName() {
        return firstName + " " + lastName;
    }


    //getters and setters
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
