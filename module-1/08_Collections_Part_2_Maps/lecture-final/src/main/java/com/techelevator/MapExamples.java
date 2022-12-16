package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExamples {

    public static void main(String[] args) {

        //BE ABLE TO DECLARE AND INSTANTIATING A HASHMAP
        Map<Integer, String> errorCodes = new HashMap<>();
        Map<String, String> products = new HashMap<>();

        //BE ABLE TO PUT STUFF IN OUR MAP
        errorCodes.put(404, "Not Found");
        errorCodes.put(418, "I AM A TEAPOT");
        errorCodes.put(600, "Bad Request");
        errorCodes.put(404, "I AM A MICROWAVE");  // IF I reuse a key it will overwrite the data
        errorCodes.put(555, "No Clue");


        System.out.println("");

        //BE ABLE TO GET STUFF OUT OF A MAP
        String teapot = errorCodes.get(418);
        errorCodes.put(418, teapot + " short and stout");


        // IF A KEY IS NOT FOUND, IT WILL RETURN NULL
        teapot = errorCodes.get(601);
        if (teapot == null) {
            System.out.println("Not Found");
        }

        //CONTAINSKEY WILL return true if key was found in map
        Integer key = 600;
        if (errorCodes.containsKey(key)) {
            System.out.println("We found key: " + key + " with a value of: " + errorCodes.get(key));
        }
        else {
            System.out.println("Not Found!");
        }

        //BE ABLE TO REMOVE STUFF FROM MAP
        String thingThatWasRemoved = errorCodes.remove(555);

        if (thingThatWasRemoved != null) {
            System.out.println(thingThatWasRemoved + " was successfully removed");
        }


        //BE ABLE TO ITERATE THROUGH A MAP
        Set<Integer> mySetOfKeys = errorCodes.keySet();

        for (Integer kee : mySetOfKeys) {
            System.out.println(errorCodes.get(kee));
        }

        //BE ABLE TO ITERATE THROUGH A MAP USING MAP.ENTRY
        for (Map.Entry<Integer, String> row : errorCodes.entrySet()) {
            Integer k = row.getKey();
            String msg = row.getValue();

            System.out.println(k + " is the key, " + msg + " is the value");
        }



        System.out.println("");











    }




}
