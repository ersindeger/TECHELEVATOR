package com.techelevator.PostageCalculator;

import java.util.*;

public class PostageCalculator {

    public static void main(String[] args) {

        List<DeliveryDriver> typeOfDelivery = new ArrayList<>() ;
        Map<Integer, String> deliveryMap = new HashMap<>();

        FirstClass usps1 = new FirstClass();
        SecondClass usps2 = new SecondClass();
        ThirdClass usps3 = new ThirdClass();

        FexEd fexEd1 = new FexEd();

        SPUNextDay spu1 = new SPUNextDay();
        SPU2Day spu2 = new SPU2Day();
        SPU4Day spu3 = new SPU4Day();

        typeOfDelivery.add(usps1);
        typeOfDelivery.add(usps2);
        typeOfDelivery.add(usps3);
        typeOfDelivery.add(fexEd1);
        typeOfDelivery.add(spu1);
        typeOfDelivery.add(spu2);
        typeOfDelivery.add(spu3);   //all of this populates the list of AllTypesOfDelivery,
        // each of which is of class "DeliveryDriver"

        deliveryMap.put(1, "Postal Service (1st Class)");
        deliveryMap.put(2, "Postal Service (2nd Class)");
        deliveryMap.put(3, "Postal Service (3rd Class)");
        deliveryMap.put(4, "FexEd                     ");
        deliveryMap.put(5, "SPU (Next Day)            ");
        deliveryMap.put(6, "SPU (2-Day Ground)        ");
        deliveryMap.put(7, "SPU (4-Day Ground)        "); // all this populates the MAP called DELIVERYMAP
        // with corresponding keys 1,2,3 etc...



        Scanner myScanner = new Scanner(System.in); // call in Scanner to read user input.


        System.out.println("Please enter the weight of the package?\n");

        String answerWeight = myScanner.nextLine(); // user input will be stored as answerWeight (as a string).
        double weight = Double.parseDouble(answerWeight); // this converts the string into double and it
        // will be stored as WEIGHT .

        System.out.println("(P)ounds or (O)unces?");

        String answerOunceOrPound = myScanner.nextLine(); // the user input will be called answerOUNCEorPOUND (String).
        String ounceOrPound = answerOunceOrPound.toLowerCase(); // it will be converted to lower case for simplicity.

        if(ounceOrPound.equals("o")){weight = weight / 16;}   //this converts all POUNDS into OUNCES for easier calculation.
        // in other words, ALL calculations will be of POUND type.

        System.out.println("What distance will it be traveling?");

        String answerDistance = myScanner.nextLine(); // the user input will be called answerDistance
        int distance =  Integer.parseInt(answerDistance); // then converted into INT and called "DISTANCE".


        int i = 1;  // will be used as a counter looping through KEYs of the deliveryMap.


        System.out.print ("Delivery Method                     $ Cost");
        System.out.println();
        System.out.print ("------------------------------------------");
        System.out.println();

        for (DeliveryDriver d : typeOfDelivery ) {

            System.out.println( deliveryMap.get(i) + "         $" + String.format("%.2f", d.calculateRate(distance,weight)));
            // formats the calculated rate to TWO DECIMALS.
            i = i + 1;  // changes the index in the key for deliveryMap
        }

    }

}

