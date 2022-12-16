package com.techelevator;
    /** observe how the package was automatically added for us above when we created the BOOK class. **/

    //STEP TWO : Create the "Book" Class

public class Book {

        public Book() {    }    //this is a custom constructor for "Book" class.


        /**
         * Adding the instance variables...
         **/

        private String title;
        private String author;
        private double price;


        /**
         * We declared the instance variables above as PRIVATE for ENCAPSULATION of the state... This restricts
         * access to the internal state of the class by hiding the instance variables and ONLY allowing them to be changed
         * THROUGH METHODS that the class makes publicly available.
         * <p>
         * i.e. class controls its internal state and ensures it remains consistent, by declaring its instance variables
         * as PRIVATE
         **/


        public String getTitle() {
            return title;
        }

        /**
         * GETTER for instance variable title
         **/
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * SETTER for instance variable title
         **/


        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }


        // Step FOUR: Add   CONSTRUCTORS    to the "Book" class. //

        public Book(String title, String author, double price) {
            this.title = title;
            this.author = author;
            this.price = price;
        }

        // Step SIX : Create a String representation of "Book" Object...
        public String bookInfo() {
            return ("Title: " + title + ", Author: " + author + ", price: " + price);
        }

    }

        // This completes the Book class...


