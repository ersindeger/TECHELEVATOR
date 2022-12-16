package com.techelevator;

public class NinjaTracker {

    public static void main(String[] args) {
        // main program to keep track of ninjas

        Ninja isStar = new Ninja();
        isStar.isVisible(false);
        isStar.setCanFight(true);
        isStar.getSpeed(100);
        isStar.getName("Istar");

        Ninja stephanie = new Ninja();
        stephanie.isVisible(false);
        stephanie.setCanFight(true);
        stephanie.getSpeed(100);
        stephanie.getName("Istar");

        System.out.println("Istar");





    }

}
