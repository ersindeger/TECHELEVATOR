package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class JavaGreenGardenManagementSystem {

    public static void main(String[] args) {

        // NEED TO BE ABLE TO DECLARE AND INSTANTIATE (create) AN ARRAYLIST
        List<Plant> plants = new ArrayList<>() ; // the second <> can be left blank or filled in with Plant.

        // OTHER EXAMPLES
        List<Double> growthPerDay = new ArrayList<>() ;
        List<String> gardeners = new ArrayList<>() ;

        // NEED TO BE ABLE TO PUT THINGS INTO THE LIST
        Plant tomato = new Plant ();
        tomato.setColor("green");
        tomato.setInDoorOnly(false);
        tomato.setLeafShape("Like a tomato leaf would like");
        tomato.setPlantName("Big Java Green Tomato");



        // NEED TO BE ABLE TO PUT THINGS INTO THE LIST
        Plant eggplant = new Plant ();
        eggplant.setColor("green");
        eggplant.setInDoorOnly(false);
        eggplant.setLeafShape("Like a leaf wn eggplant would like");
        eggplant.setPlantName("Big Java Purple Eggplant");


        // NEED TO BE ABLE TO PUT THINGS INTO THE LIST
        Plant corn = new Plant ();
        corn.setColor("yellow");
        corn.setInDoorOnly(true);
        corn.setLeafShape("Like a corn would like");
        corn.setPlantName("Big Java YELLOW Corn");


        plants.add(tomato);
        plants.add(eggplant);


        gardeners.add("Stainy");
        gardeners.add("Ian");
        gardeners.add("Miranda");
        gardeners.add("Erica");
        gardeners.add("Trae");


        //Below INSERTS DATA AT A CERTAIN INDEX
        gardeners.add(2, "Matthew");
        gardeners.add(4, "Joel");

        gardeners.set(1, "Binyam");

        // .set  (REPLACES AN ELEMENT at a certain index WITH A NEW ELEMENT)



        //BE ABLE TO SEE IF THE LIST CONTAINS AND OBJECT.
        if (gardeners.contains("Ian")){
            System.out.println("We found Ian playing in the garden");
        }
        else {
            System.out.println("Ian was garbage collected");
        }

        // .contains (CHECKS if the list contains a certain element)


        //BE ABLE TO GET THINGS OUT OF A LIST
        String whichgardener = gardeners.get(5);
        System.out.println(whichgardener);
        //this will spit out "Erica" from the list of gardeners which is at index 5.


        // BE ABLE TO LOOP THROUGH AN ARRAYLIST USING A for Loop and Look at each element
        for (int i = 0; i < gardeners.size(); i++) {

            System.out.println(gardeners.get(i));

        }


        // BE ABLE TO LOOP THROUGH AN ARRAYLIST USING A WHILE LOOP


        while (!gardeners.isEmpty()){
            System.out.println(gardeners.get(0) + "  was removed");
            gardeners.remove(0);

        }
        //.remove  REMOVES an ELEMENT AT A CERTAIN INDEX OF THE LIST.

        // .clear()   CLEARS ALL THE LIST, and makes it an empty list (list with size 0).

        // go through the list of gardeners and return a new list that only contains gardeners
        // that start with the letter M.


        List <String> namesThatStartWithM = new ArrayList<>();

        for (int i = 0; i < gardeners.size(); i++) {

            // Figure out if the current name starts with M
            // If so, add them to the list

            String name = gardeners.get(i);

            if (gardeners.get(i).startsWith("M")) {

                    namesThatStartWithM.add(name);

            }

        }










        System.out.println("");




    }



}
