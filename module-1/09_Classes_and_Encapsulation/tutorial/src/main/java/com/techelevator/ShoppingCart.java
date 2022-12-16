package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Book> booksToBuy = new ArrayList<>();

    public void add(Book bookToAdd) {
        booksToBuy.add(bookToAdd);
    }   // this method takes in the BOOK_TO_Add, and adds it to the BOOKS_TO_BUY List.


        // The method below loops through the List of BOOKs and adds each book's price to the
        // total purchase amount.

    public double getTotalPrice() {
        double total = 0;
        for (Book book : booksToBuy) {
            total = total + book.getPrice();
        }

        return total;

    }

    public String receipt() {
        String receipt = "\nReceipt\n";
        for (Book book : booksToBuy) {
            receipt = receipt + book.bookInfo();
            receipt = receipt + "\n";
        }

        receipt = receipt + "\n";

        return receipt;
    }






}
