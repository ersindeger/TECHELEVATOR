package com.techelevator;

public class SavingsAccount extends BankAccount{


    public SavingsAccount(String accountHolderName, String accountNumber, int balance){
        super(accountHolderName, accountNumber, balance);
    }

    public SavingsAccount(String accountHolderName, String accountNumber){
        super(accountHolderName, accountNumber);
    }


    @Override
    public int withdraw(int amountToWithdraw){
        int serviceFee = 2;
        int newAmountToWithdraw;

        if(getBalance() - amountToWithdraw - serviceFee < 0){
            newAmountToWithdraw = 0;
        }
        else if(getBalance() - amountToWithdraw < 150){
            newAmountToWithdraw = (amountToWithdraw + serviceFee);
        }
        else{
            newAmountToWithdraw = amountToWithdraw;
        }

        return super.withdraw(newAmountToWithdraw);

    }


}
