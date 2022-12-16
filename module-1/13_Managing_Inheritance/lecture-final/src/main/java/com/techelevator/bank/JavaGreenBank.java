package com.techelevator.bank;

import java.util.ArrayList;
import java.util.List;

public class JavaGreenBank {


    public static void main(String[] args) {

        BuckeyeSavings sav = new BuckeyeSavings();


        List<Account> myAccounts = new ArrayList<>();

        myAccounts.add(sav);

        for (Account a : myAccounts) {
            a.printStatement();
        }




    }

}
