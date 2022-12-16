package com.techelevator;

public class HomeNotFoundException extends Exception{

    private String errorMessage = "Home not found";
    private String mlsId = null;

    public HomeNotFoundException(String mlsId) {
        this.mlsId = mlsId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getMlsId() {
        return mlsId;
    }
}
