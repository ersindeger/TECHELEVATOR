package com.techelevator;

public class CheckingAccount extends BankAccount{


    public CheckingAccount(String accountHolderName, String accountNumber)
    {   super(accountHolderName, accountNumber);   }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance)
    {   super(accountHolderName, accountNumber, balance);    }

    @Override
    public int withdraw(int amountToWithdraw){
        int overdraftFee = 10;
        int newAmountToWithdraw;

        if(getBalance() - amountToWithdraw >= 0){
           newAmountToWithdraw = amountToWithdraw;
        }
        else if(getBalance() - amountToWithdraw > -100){
            newAmountToWithdraw = (amountToWithdraw + overdraftFee);
        }
        else{
            newAmountToWithdraw = 0;
        }

        return super.withdraw(newAmountToWithdraw);

    }




}
