package com.techelevator.billpayment;

public class ElectricBill extends Bill{

    private int wattsUsed;

    public ElectricBill(String accountNumber, int wattsUsed) {
        super(0, accountNumber);
        this.wattsUsed = wattsUsed;
    }

    public int getWattsUsed() {
        return wattsUsed;
    }

    public void setWattsUsed(int wattsUsed) {
        this.wattsUsed = wattsUsed;
    }


    public String toString() {
        return "Electric Bill Total = " + getBalance();
    }
}
