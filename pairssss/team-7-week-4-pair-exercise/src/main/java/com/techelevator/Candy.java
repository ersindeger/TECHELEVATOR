package com.techelevator;

public class Candy {

    private String productId;
    private String name;
    private double price;
    private boolean hasWrapper;
    private int qty;
    private String productCategory;

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isHasWrapper() {
        return hasWrapper;
    }

    public void setHasWrapper(boolean hasWrapper) {
        this.hasWrapper = hasWrapper;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
