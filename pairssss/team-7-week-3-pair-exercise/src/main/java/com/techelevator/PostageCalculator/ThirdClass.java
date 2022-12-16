package com.techelevator.PostageCalculator;

public class ThirdClass implements DeliveryDriver {

    double perMileRate;

    @Override
    public double calculateRate(int distance, double weight) {


        if (weight >= 0 && weight <= 0.125) {
            perMileRate = 0.0020;
        }
        else if (weight > 0.125 && weight <= 0.500) {
            perMileRate = 0.0022;
        }
        else if (weight > 0.500 && weight < 1) {
            perMileRate = 0.0024;
        }
        else if (weight >= 1 && weight <= 3) {
            perMileRate = 0.0150;
        }
        else if (weight >= 4 && weight <= 8) {
            perMileRate = 0.0160;
        }
        else {
            perMileRate = 0.0170;
        }

        double rate = perMileRate * distance;

        return rate;

    }
}