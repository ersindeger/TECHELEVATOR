package com.techelevator;

import java.util.*;

public class HomeInventory {

    private Map<String, Home> homeInventory = new HashMap<>();

    public HomeInventory() {

        RentalHome homeR1 = new RentalHome();
        // homeR1 is a rental home with the following attributes....

        homeR1.setSquareFeet(100);
        homeR1.setPrice(1000000.00);
        homeR1.setNumberOfBedrooms(6);
        homeR1.setHasBasement(true);
        homeR1.setMlsId("ABC123");
        homeR1.setMonthlyRent(4200);
        homeR1.setPetsAllowed(true);
        homeR1.setLeaseLengthInMonths(24);

        Address address1 = new Address();
        address1.setCity("CBUS");
        address1.setStreetName("Kinnear Rd");
        address1.setState("OH");
        address1.setZipCode("43034");
        address1.setStreetNumber("1234");

        homeR1.setAddress(address1);



        OwnedHome homeO2 = new OwnedHome();
        // homeO2 is an owned home with the following attributes....
        homeO2.setSquareFeet(10000);
        homeO2.setPrice(100.00);
        homeO2.setNumberOfBedrooms(3);
        homeO2.setHasBasement(false);
        homeO2.setMlsId("ABC456");
        homeO2.setMonthlyMortgage(2500);
        homeO2.setHoa(false);

        Address address2 = new Address();
        address2.setCity("Dublin");
        address2.setStreetName("Sawmill Rd");
        address2.setState("OH");
        address2.setZipCode("43235");
        address2.setStreetNumber("7655");

        homeO2.setAddress(address2);

        homeInventory.put(homeR1.getMlsId(), homeR1);
        homeInventory.put(homeO2.getMlsId(), homeO2);



        RentalHome homeR3 = new RentalHome();
        // homeR3 is a rental home with the following attributes....

        homeR3.setSquareFeet(2300);
        homeR3.setPrice(455000);
        homeR3.setNumberOfBedrooms(4);
        homeR3.setHasBasement(true);
        homeR3.setMlsId("FGH446");
        homeR3.setMonthlyRent(3500);
        homeR3.setPetsAllowed(false);
        homeR3.setLeaseLengthInMonths(12);

        Address address3 = new Address();
        address3.setCity("Powell");
        address3.setStreetName("Seldom Seen Rd");
        address3.setState("OH");
        address3.setZipCode("43065");
        address3.setStreetNumber("6834");

        homeR3.setAddress(address3);

        homeInventory.put(homeR3.getMlsId(), homeR3);



        OwnedHome homeO4 = new OwnedHome();
        // homeO4 is an owned home with the following attributes....
        homeO4.setSquareFeet(3400);
        homeO4.setPrice(600000);
        homeO4.setNumberOfBedrooms(5);
        homeO4.setHasBasement(true);
        homeO4.setMlsId("ZZT940");
        homeO4.setMonthlyMortgage(5100);
        homeO4.setHoa(true);

        Address address4 = new Address();
        address4.setCity("Hilliard");
        address4.setStreetName("Joyride Dr");
        address4.setState("OH");
        address4.setZipCode("43227");
        address4.setStreetNumber("11899");

        homeO4.setAddress(address4);

        homeInventory.put(homeO4.getMlsId(), homeO4);

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






}
