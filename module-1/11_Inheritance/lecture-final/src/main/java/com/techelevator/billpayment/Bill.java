package com.techelevator.billpayment;

public class Bill {

    //instance variables
    private double balance;
    private String accountNumber;

    public Bill (double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }



    //work methods
    public void payBill(double amountPaid) {
        this.balance = this.balance - amountPaid;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


}
