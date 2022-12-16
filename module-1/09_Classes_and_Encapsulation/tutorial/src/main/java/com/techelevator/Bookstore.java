package com.techelevator;

import java.util.Arrays;

        // Step ONE: Create and run the Bookstore class below that displays
        // a simple greeting message.

/**
 * Bookstore
 */
public class Bookstore {

    public static void main(String[] args) {

        System.out.println("Welcome to the Tech Elevator Bookstore");
        System.out.println();

        // Step THREE: Test the "Book" getters and setters
        // We can do this by creating an instance of a "Book" via setting values for "title", "author", "price",
        // then getting and displaying these values.
        Book twoCities = new Book ();


        twoCities.setAuthor("Charles Dickens");
        twoCities.setTitle("A Tale of Two Cities");
        twoCities.setPrice(14.99);

        System.out.println("Title: " + twoCities.getTitle() + ", Author: " + twoCities.getAuthor()
                        + ", Price: " + twoCities.getPrice());




        // Step FIVE: Test the Book constructor
        // We do this by creating TWO instances of Book using the custom creator, and display the results..

        Book threeMusketeers = new Book("The Three Musketeers", "Alexandre Dumas", 12.95);

        Book childhoodEnd = new Book("Childhood's End","Arthur Clark", 5.99);

        System.out.println("Title: " + threeMusketeers.getTitle() + ", Author: " + threeMusketeers.getAuthor()
                + ", Price: " + threeMusketeers.getPrice());
        System.out.println("Title: " + childhoodEnd.getTitle() + ", Author: " + childhoodEnd.getAuthor()
                + ", Price: " + childhoodEnd.getPrice());

        // Step SEVEN : Test the "BOOKINFO" method in "BOOK" class
        System.out.println();
        System.out.println();
        System.out.println(threeMusketeers.bookInfo());
        System.out.println(childhoodEnd.bookInfo());




        // Step NINE: Test the ShoppingCart class

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.add(twoCities);
        shoppingCart.add(threeMusketeers);
        shoppingCart.add(childhoodEnd);

        System.out.println(shoppingCart.receipt());
        System.out.println(shoppingCart.getTotalPrice());

        
    }
}
