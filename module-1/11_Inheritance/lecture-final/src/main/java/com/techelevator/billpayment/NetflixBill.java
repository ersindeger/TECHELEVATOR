package com.techelevator.billpayment;

public class NetflixBill extends Bill {

    public NetflixBill (double balance, String accountNumber) {
        super(balance, accountNumber);
    }

    private boolean hasSubscription;


    public boolean isHasSubscription() {
        return hasSubscription;
    }

    public void setHasSubscription(boolean hasSubscription) {
        this.hasSubscription = hasSubscription;
    }

    public String toString() {

        return "Netflix: Bill Total = " + getBalance();

    }

    public void payBill(double amountPaid) {     //example of override WITH super()
        amountPaid = amountPaid + 5.00;
        super.payBill(amountPaid);
    }

}
