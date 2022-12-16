package com.techelevator.noise;

public class Chainsaw implements INoise {

    private String color;
    private int size;
    boolean isOn = false;

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String makeNoise() {
        if (isOn) {
            return "chainsaw is on!";
        }
        else {
            return "Silence.. sleeping in";
        }
    }

}
