package com.techelevator.TollBoothCalculator;


public class Truck implements Vehicle{

    private int numberOfAxles;

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    public Truck(int numberOfAxles){
        this.numberOfAxles = numberOfAxles; // not sure if we should have this or not
                        // update: AS SOON AS the above line is erased, toll output for truck with 4 or 6 or 8
                      // axles becomes the same. (and obviously, they should NOT be the same)
    }


    @Override
    public double calculateToll(int distance) {
        double toll;
        if(numberOfAxles == 4){
            toll = 0.04 * distance;
        }
        else if(numberOfAxles == 6){
            toll = 0.045 * distance;
        }
        else
            { toll = 0.048 * distance;  }

        return toll;
    }

}
