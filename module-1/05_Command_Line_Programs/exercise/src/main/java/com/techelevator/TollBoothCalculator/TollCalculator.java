package com.techelevator.TollBoothCalculator;

import java.util.*;


public class TollCalculator {

    public static void main(String[] args) {

        List<Vehicle> typeOfVehicle = new ArrayList<>() ;
        Map<Integer, String> vehiclesMap = new HashMap<>();


        Car car1 = new Car(false);
        Car car2 = new Car(true);

        Truck truck1 = new Truck(4);
        Truck truck2 = new Truck(6);
        Truck truck3 = new Truck(8);

        Tank tank1 = new Tank();

        vehiclesMap.put(1, "Car                  ");
        vehiclesMap.put(2, "Car (with trailer)   ");
        vehiclesMap.put(3, "Truck (with 4 axles) ");
        vehiclesMap.put(4, "Truck (with 6 axles) ");
        vehiclesMap.put(5, "Truck (with 8 axles) ");
        vehiclesMap.put(6, "Tank                 "); // we just populated "vehiclesMap".


        typeOfVehicle.add(car1);
        typeOfVehicle.add(car2);
        typeOfVehicle.add(truck1);
        typeOfVehicle.add(truck2);
        typeOfVehicle.add(truck3);
        typeOfVehicle.add(tank1);  // we just populated the list "typeOfVehicle".

        System.out.println();
        System.out.print ("Vehicle                         Distance Traveled      Toll $");
        System.out.println();
        System.out.print ("-------------------------------------------------------------");
        System.out.println();
        System.out.println();
        int totalDistance = 0;
        double totalToll = 0;

        int i = 1;  // will be used as a counter looping through KEYs of the vehiclesMap.

        for (Vehicle v : typeOfVehicle ) {

            Random r = new Random(); // this helps generate a random value for DISTANCE below
            int distance = r.nextInt(231) + 10; //selects a random integer UPTO and NOT including 231, and then adds 10 on
                                                    // it.. so the random integer (called DISTANCE) is b/w 10 & 240.

            String space = "";   // no space really..
            if(distance <= 99){space = " ";}  //inserts an extra space, if distance is a 2-digit number, instead of 3-digit

            System.out.println( vehiclesMap.get(i) + "           " + distance + space + "                    " +
                 "$" +  String.format("%.2f", v.calculateToll(distance)) );
                                            // String.format("%.2f, SOME_INPUT) : rounds to TWO decimal point...

            totalDistance = totalDistance + distance;  // keeps adding distances
            totalToll = totalToll + v.calculateToll((int) distance); // keeps adding tolls
            i = i + 1;                                 // changes the index in the key for VehiclesMap
        }

        System.out.println();
        System.out.println("Total Miles Traveled:       " + totalDistance);

        System.out.println( "Total Tollbooth Revenue:   $" + String.format("%.2f",totalToll) );
    }

}
