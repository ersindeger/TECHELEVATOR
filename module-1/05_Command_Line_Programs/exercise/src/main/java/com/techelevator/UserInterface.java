package com.techelevator;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner myScanner = new Scanner(System.in);


    public int printMainMenu() {
        System.out.println("Candy Store Main Menu");
        System.out.println("(1) Show Inventory");
        System.out.println("(2) Make Sale");
        System.out.println("(3) Quit");

        int userInputAsInt = 0;

        try {

            String userInputAsString = myScanner.nextLine();
            userInputAsInt = Integer.parseInt(userInputAsString);
        }
        catch (NumberFormatException e) {
            printMessage("Invalid choice.");
        }
        return userInputAsInt;
    }


    public void printCandy(List<Candy> candy) {

        System.out.printf("%-25s %-20s %-15s %-10s %-5s", "Id", "Name", "Wrapper", "Qty", "Price");
        System.out.println();

        for (Candy c : candy) {
            String wrapper = "Y";
            if (!c.isHasWrapper()) {
                wrapper = "N";
            }
            String qty = String.valueOf(c.getQty());
            if (c.getQty() == 0) {
                qty = "SOLD OUT";
            }

            System.out.printf("%-25s %-20s %-15s %-10s %s %-5.2f", c.getProductId(), c.getName(), wrapper,  qty,
                    "$", c.getPrice());
            System.out.println();
        }
    }

    public void printChange(List<Integer> denominations, double change){

        System.out.println("Change: $" + String.format("%.2f", change ));

        System.out.println("("+denominations.get(0)+") Twenties, (" + denominations.get(1)+") Tens, " +
                "("+denominations.get(2)+") Fives, " + "("+denominations.get(3)+") Ones, (" +
                denominations.get(4)+") Quarters, (" + denominations.get(5)+") Dimes, (" +
                denominations.get(6)+") Nickels.");


    }

    public void printReceipt (List<Candy> shoppingList){
        for (Candy c: shoppingList){
            String productCategoryName;
            if(c.getProductCategory().equals("CH")){
                productCategoryName = "Chocolate Confectionery";
            }
            else if(c.getProductCategory().equals("LI")){
                productCategoryName = "Licorice and Jellies   ";
            }
            else if(c.getProductCategory().equals("SR")){
                productCategoryName = "Sour Flavored Candies  ";
            }
            else{productCategoryName = "Hard Tack Confectionery";}

            System.out.printf("%-5s %-20s %10s %10s %1.2f %10s %1.2f", c.getQty(), c.getName(), productCategoryName,
                    "$", c.getPrice()/c.getQty(),"$", c.getPrice());

            System.out.println();
        }
    }

    public void printCartTotal (double cartTotal){
        System.out.println("Total:  $" + String.format("%.2f",cartTotal));
    }




    public int printSubmenu (){

        System.out.println("(1) Deposit Money");
        System.out.println("(2) Select Products");
        System.out.println("(3) Complete Sale");
        System.out.println();

        int userInputAsInt = 0;

        try {

            String userInputAsString = myScanner.nextLine();
            userInputAsInt = Integer.parseInt(userInputAsString);
        }
        catch (NumberFormatException e) {
            printMessage("Invalid choice.");
        }
        return userInputAsInt;
    }


    public void printMessage(String msg) {

        System.out.println(msg);
    }


    public int askForDepositAmount() {
        printMessage("Please enter a whole dollar amount up to $100");

        int requestedDeposit = 0;

        try {

            String userInput = myScanner.nextLine();
            requestedDeposit = Integer.parseInt(userInput);
        }
        catch (NumberFormatException e) {
            printMessage("Please enter a whole number.");
        }
        return requestedDeposit;


    }




    public void displayCurrentBalance(double balance) {
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
    }



    public String checkId() {

        System.out.println("Please enter a product ID.");

        String productId = myScanner.nextLine();

        return productId;

    }


    public int requestedQty() throws NumberFormatException {

        printMessage("Please enter how many you would like to purchase.");

        int requestedQty = 0;

        try {

            String userInput = myScanner.nextLine();
            requestedQty = Integer.parseInt(userInput);
        }
        catch (NumberFormatException e) {
            printMessage("Please enter a whole number.");
        }
        return requestedQty;
    }
}


