package com.techelevator.store;

import java.util.ArrayList;
import java.util.List;

public class StoreApp {

    public static void main(String[] args) {

        Plane plane = new Plane(5, 100);
        Plane realPlane = new Plane(1, 1000000);

        Eggs egg = new Eggs(12, 2.00);

        Laptop laptop = new Laptop(14, 1000);

        List<Sellable> itemsForSale = new ArrayList<>();
        itemsForSale.add(plane);
        itemsForSale.add(realPlane);
        itemsForSale.add(egg);
        itemsForSale.add(laptop);


        for (Sellable item: itemsForSale) {
            System.out.println(item.toString() + " " + item.getPrice() + " " + item.getQuantity());
            if (item instanceof Eggs) {
                System.out.println(((Eggs) item).eat());
            }
        }






    }
}
