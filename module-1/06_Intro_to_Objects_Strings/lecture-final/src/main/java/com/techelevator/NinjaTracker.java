package com.techelevator;

public class NinjaTracker {

    public static void main(String[] args) {
        //main program to keep track of ninjas

        Ninja isStar = new Ninja();
        isStar.setVisible(false);
        isStar.setCanFight(true);
        isStar.setSpeed(100);
        isStar.setName("Istar");


        Ninja stephanie = new Ninja();
        stephanie.setVisible(false);
        stephanie.setCanFight(true);
        stephanie.setSpeed(99);
        stephanie.setName("Stephanie");


        System.out.println(isStar.getName());

        System.out.println(stephanie.getName());

        stephanie.setSpeed(101);
        stephanie.setName("The ninja formerly known as Stephanie");

        stephanie = null;


    }
}
