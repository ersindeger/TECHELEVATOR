package com.techelevator.PostageCalculator;


public class SPU2Day implements DeliveryDriver {

    double rate;


    @Override
    public double calculateRate(int distance, double weight) {

        rate = (weight * 0.050) * distance;

        return rate;
    }
}
