package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Cashbox {

    private double customerBalance = 0;

    public Cashbox() {
    }

    public void addToBalance(int depositAmount) {
        customerBalance += depositAmount;
    }

    public void subtractFromBalance(double purchaseAmount) {
        customerBalance -= purchaseAmount;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }


    public List<Integer> giveChange() {
        double twenties = getCustomerBalance() /20;
        double tens = getCustomerBalance()%20  / 10;
        double fives = getCustomerBalance()%10  / 5;
        double ones = getCustomerBalance()%5  / 1;
        double quarters = ( getCustomerBalance()%1 )  / 0.25;
        double dimes =  Math.round((100*(getCustomerBalance() - (int)getCustomerBalance() - (int)quarters * 0.25)))/10;
        double nickels = Math.round((100*(getCustomerBalance() - (int)getCustomerBalance() - (int)quarters * 0.25 - (int)dimes * 0.10)))/5;

        List<Integer> finalChangeList = new ArrayList<>();
        finalChangeList.add(0, (int)twenties);
        finalChangeList.add(1,  (int)tens);
        finalChangeList.add(2,  (int)fives);
        finalChangeList.add(3,  (int)ones);
        finalChangeList.add(4,  (int)quarters);
        finalChangeList.add(5,  (int) Math.round(dimes));
        finalChangeList.add(6,  (int) Math.round(nickels));

        return finalChangeList;
    }

    public void resetBalanceToZero(){

        customerBalance = 0;

    }







}
