package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart
 */
public class ShoppingCart {

	private List<MediaItem> itemsToBuy = new ArrayList<>();

	public void add(MediaItem bookToAdd) {
	    itemsToBuy.add(bookToAdd);
	}

	public double getTotalPrice() {
	    double total = 0.0;
	    for (MediaItem mediaItem : itemsToBuy) {
	        total += mediaItem.getPrice();
	    }
	    return total;
	}

	public String receipt() {
	    String receipt = "\nReceipt\n";
	    for (MediaItem mediaItem : itemsToBuy) {
	        receipt += mediaItem;
	        receipt += "\n";
	    }

	    receipt += "\nTotal: $" + getTotalPrice();

	    return receipt;
	}
}
