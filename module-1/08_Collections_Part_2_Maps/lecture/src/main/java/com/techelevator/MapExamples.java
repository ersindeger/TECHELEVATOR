package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MapExamples {

    public static void main(String[] args) {

        //BE ABLE TO DECLARE AND INSTANTIATE A HASHMAP
        Map<Integer, String> errorCodes = new HashMap<>();
        Map<Integer, String> products = new HashMap<>();


        //BE ABLE TO PUT STUFF IN OUR MAP
        errorCodes.put(404, "Not Found");
        errorCodes.put(418, "I am a TeaPot");
        errorCodes.put(400, "Bad Request");
        errorCodes.put(252, "Bad HTTPS information");
        errorCodes.put(404, "I AM A MICROWAVE"); // If I REUSE a key, it will overwrite the data!
        errorCodes.put(555, "No clue whatsoever!");

        System.out.println();


        // BE ABLE TO GET STUFF OUT OF A MAP
        String teapot = errorCodes.get(418);

        errorCodes.put(418,teapot + " short and stout"); //rewrote key 418 with this on the left.


        teapot = errorCodes.get(600);


        System.out.println(teapot);

        if (teapot == null){
            System.out.println("Not found!");
        }


        Integer key = 600;
        if (errorCodes.containsKey(600)){
            System.out.println("We found key : " + key + " with a value of " + errorCodes.get(key));
        }

        else{
            System.out.println("Not Found!!");
        }


        // BE ABLE TO REMOVE
       // .remove(key)

        String thingThatWasRemoved = errorCodes.remove(555);

        System.out.println("");


        // BE ABLE TO ITERATE THRU A MAP
        Set<Integer> mySetOfKeys = errorCodes.keySet();

        for (Integer kee : mySetOfKeys){
            System.out.println(errorCodes.get(kee));
        }


        //BE ABLE TO ITERATE THRU A MAP   USING   MAP.ENTRY
        for ( Map.Entry<Integer, String> row : errorCodes.entrySet() ) {

            Integer k = row.getKey();
            String msg = row.getValue();

            System.out.println( k + " is the key,"  +  msg + " is the value");

        }



        System.out.println();



    }
}
