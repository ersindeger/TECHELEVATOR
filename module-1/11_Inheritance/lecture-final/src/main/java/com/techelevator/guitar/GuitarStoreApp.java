package com.techelevator.guitar;

import java.util.ArrayList;
import java.util.List;

public class GuitarStoreApp {

    public static void main(String[] args) {
        ElectricGuitar gtr6 = new ElectricGuitar(6);  // creates a guitar with 6 strings
        gtr6.setNumberOfPickups(2);
     //   gtr6.play();

        ElectricGuitar gtr12 = new ElectricGuitar(12); //creates a guitar with 12 strings
        gtr12.setNumberOfPickups(1);

        AcousticGuitar ac = new AcousticGuitar(6);
      //  ac.play();

        List<Guitar> guitars = new ArrayList<>();

        guitars.add(gtr6);
        guitars.add(gtr12);
        guitars.add(ac);

        for (Guitar g : guitars) {
            g.play();
        }







        System.out.println("");

    }
}
