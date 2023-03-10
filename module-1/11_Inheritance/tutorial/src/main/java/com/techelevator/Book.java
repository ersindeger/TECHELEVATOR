package com.techelevator;

/**
 * Book
 */
public class Book extends MediaItem {    //shows that Book is SUBCLASS (child) and MediaItem is SUPERCLASS (parent)


	private String title;
	private double price;
    private String author;


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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Book(String title, String author, double price) {
	    this.title = title;
	    this.author = author;
	    this.price = price;
	}
	
	public Book() {
	}

	@Override
	public String toString() {
	    return "Title: " + title + ", Author: " + author + ", Price: $" + price;
	}



}




