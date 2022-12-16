package com.techelevator;

import java.util.*;

public class HomeInventory {

    private Map<String, Home> homeInventory = null;

    public HomeInventory() {

        HomeFileReader reader = new HomeFileReader();
        homeInventory = reader.loadHomes();
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


    public Home searchByMLSId(String mlsId) throws HomeNotFoundException {

        Home foundHome = homeInventory.get(mlsId);

        if (foundHome == null) {
            throw new HomeNotFoundException(mlsId);
        }
        return foundHome;

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

    public void addHome(Home newHome) {

        homeInventory.put(newHome.getMlsId(), newHome);
    }




}
