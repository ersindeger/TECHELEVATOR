package com.techelevator.PostageCalculator;


public class SecondClass implements DeliveryDriver {

    double perMileRate;

    @Override
    public double calculateRate(int distance, double weight) {


        if (weight >= 0 && weight <= 0.125) {
            perMileRate = 0.0035;
        }
        else if (weight > 0.125 && weight <= 0.500) {
            perMileRate = 0.0040;
        }
        else if (weight > 0.500 && weight < 1) {
            perMileRate = 0.0047;
        }
        else if (weight >= 1 && weight <= 3) {
            perMileRate = 0.0195;
        }
        else if (weight >= 4 && weight <= 8) {
            perMileRate = 0.0450;
        }
        else {
            perMileRate = 0.0500;
        }

        double rate = perMileRate * distance;

        return rate;

    }
}
