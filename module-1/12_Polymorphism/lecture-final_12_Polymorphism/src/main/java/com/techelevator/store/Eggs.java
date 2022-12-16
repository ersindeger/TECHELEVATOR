package com.techelevator.store;

public class Eggs implements Sellable {


    private int quantity;
    private double price;


    public Eggs(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    public String eat() {
        return "get in ma belly!";
    }


    public String toString() {
        return "Eggs";
    }
}
