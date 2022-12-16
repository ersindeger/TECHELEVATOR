package com.techelevator.PostageCalculator;


public class FirstClass implements DeliveryDriver {

    double perMileRate;


    @Override
    public double calculateRate(int distance, double weight) {

        if (weight >= 0 && weight <= 0.125) {
            perMileRate = 0.035;
        }
        else if (weight >= 0.1875 && weight <= 0.5) {
            perMileRate = 0.040;
        }
        else if (weight >= 0.5625 && weight < 1) {
            perMileRate = 0.047;
        }
        else if (weight >= 1 && weight <= 3) {
            perMileRate = 0.195;
        }
        else if (weight >= 4 && weight <= 8) {
            perMileRate = 0.450;
        }
        else {
            perMileRate = 0.500;
        }

        double rate = perMileRate * distance;

        return rate;
    }
}
