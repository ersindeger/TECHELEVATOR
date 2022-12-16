package com.techelevator.noise;

import java.util.ArrayList;
import java.util.List;

public class Soundboard {

    public static void main(String[] args) {

        INoise chainsaw = new Chainsaw();
        ((Chainsaw) chainsaw).setOn(true);
        INoise doorbell = new Doorbell();

        Doorbell anotherDoorBell = new Doorbell();

        List<INoise> noisyThings = new ArrayList<>();
        noisyThings.add(chainsaw);
        noisyThings.add(doorbell);
        noisyThings.add(anotherDoorBell);

        for (INoise thing: noisyThings) {
            System.out.println(thing.makeNoise());
        }









    }


}
