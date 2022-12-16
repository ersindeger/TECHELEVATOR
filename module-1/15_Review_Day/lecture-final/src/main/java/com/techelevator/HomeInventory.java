package com.techelevator;

import java.util.*;

public class HomeInventory {

    private Map<String, Home> homeInventory = new HashMap<>();

    public HomeInventory() {

        OwnedHome home1 = new OwnedHome();
        home1.setSquareFeet(100);
        home1.setPrice(1000000.00);
        home1.setNumberOfBedrooms(6);
        home1.setHasBasement(true);
        home1.setMlsId("ABC123");
        home1.setHasHOA(true);

        Address address1 = new Address();
        address1.setCity("CBUS");
        address1.setStreetName("Kinnear Rd");
        address1.setState("OH");
        address1.setZipCode("43034");
        address1.setStreetNumber("1234");

        home1.setAddress(address1);


        RentalHome home2 = new RentalHome();
        home2.setSquareFeet(10000);
        home2.setPrice(100.00);
        home2.setNumberOfBedrooms(3);
        home2.setHasBasement(false);
        home2.setMlsId("ABC456");
        home2.setMonthlyRent(450.00);

        Address address2 = new Address();
        address2.setCity("Dublin");
        address2.setStreetName("Sawmill Rd");
        address2.setState("OH");
        address2.setZipCode("43017");
        address2.setStreetNumber("12");

        home2.setAddress(address2);

        homeInventory.put(home1.getMlsId(), home1);
        homeInventory.put(home2.getMlsId(), home2);


    }

    public List<Home> retrieveListOfHomes() {

        List<Home> foundHomes = new ArrayList<>();

       Set<String> keys = homeInventory.keySet();

       for (String key: keys) {
           Home temp = homeInventory.get(key);
           foundHomes.add(temp);
       }


       return foundHomes;


    }


    public Home searchByMLSId(String mlsId) {

        return homeInventory.get(mlsId);

    }

    public boolean deleteHome(String mlsId) {

        if (homeInventory.containsKey(mlsId)) {
            homeInventory.remove(mlsId);
            return true;
        }
        else {
            return false;
        }
    }




}
