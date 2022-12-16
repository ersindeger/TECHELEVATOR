package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    private List<Accountable> accounts = new ArrayList<>();
    private String name;
    private String address;
    private String phoneNumber;
    private boolean isVip;

    public boolean isVip() {
        int totalBalance = 0;
        for (Accountable accountEach : accounts ) {
            totalBalance = totalBalance + accountEach.getBalance();
        }

            if (totalBalance >= 25000)
                {return true;}
            else
                return false;

    }


    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[0]);
    }

    public void addAccount(Accountable newAccount) {
        accounts.add(accounts.size(), newAccount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
