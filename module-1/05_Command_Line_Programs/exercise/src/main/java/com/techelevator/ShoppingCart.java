package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Candy> shoppingCart = new ArrayList<>();

    public void addToShoppingCart(Candy candy) {

        shoppingCart.add(candy);
    }


    public List<Candy> getShoppingCart() {
        return shoppingCart;
    }

    public double getTotalShoppingCartAmount (List<Candy> shoppingCart){

        double totalAmount = 0;
        for(Candy c: shoppingCart){
            totalAmount += c.getPrice();
        }
        return totalAmount;

    }

    public void resetShoppingCart() {
        shoppingCart.clear();
    }


}
