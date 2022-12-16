package com.techelevator.PostageCalculator;


public class SPU4Day implements DeliveryDriver {

    double rate;

    @Override
    public double calculateRate(int distance, double weight) {

        rate = (weight * 0.0050) * distance;

        return rate;
    }
}