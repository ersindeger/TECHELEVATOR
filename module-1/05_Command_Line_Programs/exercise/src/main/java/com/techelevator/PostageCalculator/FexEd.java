package com.techelevator.PostageCalculator;


public class FexEd implements DeliveryDriver {

    //rate = 20.00
    //If distance > 500 miles then rate = rate + 5.00
    //If weight > 48 ounces then rate = rate + 3.00

    @Override
    public double calculateRate(int distance, double weight) {

        int rate = 20;

        if (distance > 500) {
            rate = rate + 5;
        }

        if (weight > 3) {
            rate = rate + 3;
        }
        return rate;
    }
}
