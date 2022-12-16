package com.techelevator.jgbank;

public class SavingsAccount {

    // member variables or class variables or instance variables below...
    private double balance;
    private String accountNumber;
    private String firstName;
    private String lastName;

    public SavingsAccount(double openingBalance){
        this.balance = 50;
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

    public void withdraw(double amountToWithdraw){

        //Validate they have enough money in their account
        if (isValidWithdrawal(amountToWithdraw)){
            this.balance = this.balance - amountToWithdraw;
        }

    }

    private boolean isValidWithdrawal(double amountToWithdraw){

        if(amountToWithdraw <= this.balance){
            return true;
        }
        else
            return false;
    }



    //deposit method
    public void deposit(double amountToDeposit){

        if(amountToDeposit > 0) {
            this.balance = this.balance + amountToDeposit; //this.balance += amountToDeposit
        }
    }


    //getters and setters
    public void getBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
