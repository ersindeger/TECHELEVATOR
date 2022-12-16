package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserCredentials;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printGreeting() {
        System.out.println("*********************");
        System.out.println("* Welcome to TEnmo! *");
        System.out.println("*********************");
    }

    public void printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("1: View your current balance");
        System.out.println("2: View your past transfers");
        System.out.println("3: View your pending requests");
        System.out.println("4: Send TE bucks");
        System.out.println("5: Request TE bucks");
        System.out.println("0: Exit");
        System.out.println();
    }

    public UserCredentials promptForCredentials() {
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public BigDecimal promptForBigDecimal(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printMessage (String message) { System.out.println(message); }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

    public void printUsers(List<User> users) {
        for (User user : users)
            System.out.println(user.getId() + "    " + user.getUsername());
    }


    public void printBalance(BigDecimal balance) {
        System.out.println("Your current account balance is: $" + balance);
    }


    public BigDecimal getAmount() {

        System.out.println("What amount is being transferred? ");

            BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
                                          // converts STR into DOUBLE and then THAT into BIG DECIMAL
        return amount;
    }

    public void printJustTheHeaderForListOfTransfers() {
        System.out.println("--------------------------------------------------");
        System.out.println("List of Transfers for logged in user: ");
        System.out.println("ID" + "          " + "From" + "         " + "To" + "          " + "Amount");
        System.out.println("--------------------------------------------------");
    }

    public void printTransfers(List<Transfer> transfers) {
        printJustTheHeaderForListOfTransfers();

        for (Transfer transfer : transfers) {

            System.out.printf("%-5s %10s %10s %10s %1.2f", transfer.getTransferId(), transfer.getUserFrom(), transfer.getUserTo(),
                    "$", transfer.getAmount());
            System.out.println();

        }

    }

    public void printTransferId(Transfer transfer) {

        if (transfer == null) {
            System.out.println();
            System.out.println("This is an invalid Transfer ID");
        }
        else{
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-5s %10s %8s %13s %12s %13s", "Transfer ID", "From", "To",
                   "Type", "Status", "$ Amount");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println();

       System.out.printf("%-5s %16s %10s %11s %14s %5s %1.2f", transfer.getTransferId(), transfer.getUserFrom(), transfer.getUserTo(),
                    transfer.getTransferTypeMessage(), transfer.getTransferStatusMessage(),"$", transfer.getAmount());
       System.out.println();}

    }

    public int getUserIdTo() {
        System.out.println("What userID would you like to send money to? ");

        while (true) {
            try { return Integer.parseInt(scanner.nextLine()); }    // <=== gets the USERID of the transferee.
            catch (NumberFormatException e) { System.out.println("Please enter a VALID User ID"); }
                                                                    // <=== catches an improper entry i.e. non-integer!
        }
    }

}

