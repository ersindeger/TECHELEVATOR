package com.techelevator.store;

public class Plane implements Sellable, Flyable{

    private int quantity;
    private double price;


    public Plane(int quantity, double price) {
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
        return "Plane";
    }

    @Override
    public void fly() {

    }
}
