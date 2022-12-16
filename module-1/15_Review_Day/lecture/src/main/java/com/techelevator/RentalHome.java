package com.techelevator;

public class RentalHome extends Home {


    private int monthlyRent;
    private boolean isPetsAllowed;
    private int leaseLengthInMonths;

//    public RentalHome (int squareFeet, String mlsId, int numberOfBedrooms, boolean hasBasement,
//                      Address address) {
//        super(squareFeet, mlsId, numberOfBedrooms, hasBasement, address);
//    }

    public int getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(int monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public boolean isPetsAllowed() {
        return isPetsAllowed;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        isPetsAllowed = petsAllowed;
    }

    public int getLeaseLengthInMonths() {
        return leaseLengthInMonths;
    }

    public void setLeaseLengthInMonths(int leaseLengthInMonths) {
        this.leaseLengthInMonths = leaseLengthInMonths;
    }


}


