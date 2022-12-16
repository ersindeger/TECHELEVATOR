package com.techelevator.billpayment;

public class BillSystem {

    public static void main(String[] args) {

        NetflixBill nf = new NetflixBill(100.00, "ABC");
        nf.setHasSubscription(true);

        ElectricBill eb = new ElectricBill("4567", 10);
        eb.setBalance(250.00);


        nf.payBill(20.00);
        eb.payBill(249.00);

        System.out.println(nf.toString());
        System.out.println(eb.toString());


    }
}
