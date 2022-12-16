package com.techelevator.guitar;

public class ElectricGuitar extends Guitar {

     private int numberOfPickups;

     public ElectricGuitar(int numberOfStrings) {
         super(numberOfStrings);
     }


    public void play() {
        System.out.println("awesome shredding!!! Dude!");
    }

    public int getNumberOfPickups() {
        return numberOfPickups;
    }

    public void setNumberOfPickups(int numberOfPickups) {
        this.numberOfPickups = numberOfPickups;
    }
}
