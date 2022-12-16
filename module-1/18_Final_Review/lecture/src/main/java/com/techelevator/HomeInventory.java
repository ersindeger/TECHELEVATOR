package com.techelevator;

import java.util.*;

public class HomeInventory {

    private Map<String, Home> homeInventory = new HashMap<>();

    public HomeInventory() {

        OwnedHome home1 = new OwnedHome();
        home1.setMlsId("ABC123");
        home1.setSquareFeet(100);
        home1.setListingPrice(10000.00);
        home1.setNumberOfBedrooms(6);
        home1.setHasHOA(true);
        home1.setSquareFeet(2000);
        home1.setDescription("This is house 1 description");


        Address address1 = new Address();
        address1.setCity("Columbus");
        address1.setAddressLine1("123 Oak Street");
        address1.setState("OH");
        address1.setZip("43022");

        home1.setAddress(address1);

        RentalHome home2 = new RentalHome();
        home2.setSquareFeet(10000);
        home2.setNumberOfBedrooms(3);
        home2.setMonthlyRent(4000.00);
        home2.setListingPrice(230000.30);
        home2.setMlsId("ABC456");
        home2.setDescription("This is house 1 description");

        Address address2 = new Address();
        address2.setCity("Dublin");
        address2.setAddressLine1("123 Main Street");
        address2.setState("OH");
        address2.setZip("43017");

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
