package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class JavaGreenGardenManagementSystem {

    public static void main(String[] args) {

        //NEED TO BE ABLE TO DECLARE AND INSTANTIATE(CREATE) A ARRAYLIST
        List<Plant> plants = new ArrayList<>();

        //OTHER EXAMPLES
        List<Double> growthRatePerDay = new ArrayList<>();
        List<String> gardeners = new ArrayList<>();


        // NEED TO BE ABLE TO PUT THINGS INTO THE LIST
        Plant tomato = new Plant();
        tomato.setColor("green");
        tomato.setIndoorOnly(false);
        tomato.setLeafShape("like a tomato leaf would look like");
        tomato.setPlantName("Big Java Greenie Tomato");

        Plant squash = new Plant();
        squash.setColor("orange");
        squash.setIndoorOnly(false);
        squash.setLeafShape("like a squash leaf big and puffy");
        squash.setPlantName("Big Squashy Butternut");

        Plant  corn = new Plant();
        corn.setColor("yellow");
        corn.setIndoorOnly(false);
        corn.setLeafShape("tall");
        corn.setPlantName("Field Corn");



        plants.add(tomato);
        plants.add(squash);
        plants.add(corn);



        gardeners.add("Stainy");
        gardeners.add("Ian");
        gardeners.add("Miranda");
        gardeners.add("Erica");
        gardeners.add("Trae");

        //BE ABLE TO INSERT DATA AT A CERTAIN INDEX
        gardeners.add(2, "Matthew");
        gardeners.add(4, "Joel");


        gardeners.set(1, "Binyam");

        //BE ABLE TO SEE IF THE LIST CONTAINS AN OBJECT
        if (gardeners.contains("Ian")) {
            System.out.println("We found Ian playing in the garden");
        }
        else {
            System.out.println("Ian was garbage collected");
        }

        //BE ABLE TO GET THINGS OUT OF A LIST
        String erica = gardeners.get(5);
        System.out.println(erica);

        // BE ABLE TO LOOP THROUGH AN ARRAYLIST USING A STANDARD FOR LOOP AND LOOK AT EACH ELEMENT
        for (int i=0; i< gardeners.size(); i++) {

            System.out.println(gardeners.get(i));

        }

        // BE ABLE TO LOOP THROUGH AN ARRAYLIST USING A WHILE LOOP

//        while (!gardeners.isEmpty()) {
//
//            System.out.println(gardeners.get(0) + " was removed");
//            gardeners.remove(0);
//        }

     //   gardeners.clear();



        // go through the list of gardeners and return a NEW LIST that only contains gardeners whose name starts with the letter M.

        List<String> namesThatStartWithM = new ArrayList<>();

        for (int i = 0; i < gardeners.size(); i++) {

            //figure out if the current name starts with the letter m
            //if so, add them to the new list

           String name = gardeners.get(i);
           if (name.startsWith("M")) {
               namesThatStartWithM.add(name);
           }

        }



        System.out.println("");


























    }



}
