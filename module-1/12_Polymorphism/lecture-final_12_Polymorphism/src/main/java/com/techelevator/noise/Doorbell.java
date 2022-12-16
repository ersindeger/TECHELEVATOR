package com.techelevator.noise;

public class Doorbell implements INoise{

    private String make;
    private String model;


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String makeNoise() {
        return "ding";
    }
}
