package com.techelevator;

import java.util.*;

public class CandyInventory {

    private Map<String, Candy> candyInventory = new TreeMap<>();


    public CandyInventory() {

        CandyFileReader reader = new CandyFileReader();
        candyInventory = reader.loadCandy();
    }


    public List<Candy> retrieveListOfCandy() {

        List<Candy> candyList = new ArrayList<>();
        Set<String> keys = candyInventory.keySet();

        for (String key : keys) {
            Candy temp = candyInventory.get(key);
            candyList.add(temp);
        }
        return candyList;
    }


    public String retrieveName(String productId){
        String productName =  candyInventory.get(productId).getName();
        return productName;
    }

    public String retrieveCategory(String productId){
        String categoryName =  candyInventory.get(productId).getProductCategory();
        return categoryName;
    }



    public boolean containsProductId(String productId) {
        Set<String> keys = candyInventory.keySet();

        try {

            if (keys.contains(productId)) {
                return true;
            } else {
                return false;
            }
        }
        catch (NullPointerException e) {
            return false;
        }
    }


    public boolean hasStock(String productId) {

        if (candyInventory.get(productId).getQty() > 0) {
            return true;
        }
        else {
            return false;
        }
    }


    public boolean hasEnoughQty(String productId, int requestedQty) {

        if (requestedQty < 0) {
            return false;
        }

        if (candyInventory.get(productId).getQty() >= requestedQty) {
            return true;
        }
        else {
            return false;
        }
    }


    public double calculateCostOfCandyQty(String productId, int requestQty) {

        double costOfCandyQty = candyInventory.get(productId).getPrice() * requestQty;

        return costOfCandyQty;
    }


    public void takeItemOutOfInventory(String productId, int numberOfItems){

        candyInventory.get(productId).setQty(candyInventory.get(productId).getQty() - numberOfItems);
    }

}
