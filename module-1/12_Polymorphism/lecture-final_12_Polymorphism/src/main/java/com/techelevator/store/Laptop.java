package com.techelevator.store;

public class Laptop implements Sellable {

    private int quantity;
    private double price;

    public Laptop(int quantity, double price) {
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

    public String toString() {
        return "Laptop";
    }
}
