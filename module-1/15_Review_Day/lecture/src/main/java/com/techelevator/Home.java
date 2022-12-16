package com.techelevator;

public class Home {

    private double price;
    private int squareFeet;
    private String mlsId;
    private int numberOfBedrooms;
    private boolean hasBasement;
    private Address address;

//    public Home(int squareFeet, String mlsId, int numberOfBedrooms, boolean hasBasement, Address address) {
//    this.squareFeet = squareFeet;
//    this.mlsId = mlsId;
//    this.numberOfBedrooms = numberOfBedrooms;
//    this.hasBasement = hasBasement;
//    this.address = address;
//    }
//
//    public Home() {
//
//    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    public String getMlsId() {
        return mlsId;
    }

    public void setMlsId(String mlsId) {
        this.mlsId = mlsId;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public boolean isHasBasement() {
        return hasBasement;
    }

    public void setHasBasement(boolean hasBasement) {
        this.hasBasement = hasBasement;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
