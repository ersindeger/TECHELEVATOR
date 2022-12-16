package com.techelevator;

public class MediaItem  implements Purchasable  {     //  <===== changed the class declaration!!

    // Since MediaItem already has a getPrice() method, there's nothing else we need to do.
    // MediaItem now completely implements the Purchasable interface.


    protected String title;
    protected double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
