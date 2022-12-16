package com.techelevator.TollBoothCalculator;


public class Car implements Vehicle {

    private boolean hasTrailer;

    public boolean isHasTrailer() {
        return hasTrailer;
    }


    public Car(boolean hasTrailer){
        this.hasTrailer = hasTrailer;  // not sure if we should have this or not....
                                    // update: AS SOON AS the above line is erased, toll formula for car with or without
                                    // trailer becomes the same. (and obviously, it should NOT be the same)
    }

    @Override
    public double calculateToll(int distance) {
        double toll = 0;

        if(hasTrailer){
            toll = (distance * 0.02) + 1.00;
        }
        else
            toll = distance * 0.02;

            return toll;
    }

}
