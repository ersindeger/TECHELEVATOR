package com.techelevator;

public class Plant {

    private String color;
    private String leafShape;
    private boolean isIndoorOnly;
    private String plantName;

    public void waterPlant() {
        System.out.println("Thanks I was thirsty!");
    }

    public void talkToPlant(String word) {
        System.out.println(word + "  thanks for talking to me");
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLeafShape() {
        return leafShape;
    }

    public void setLeafShape(String leafShape) {
        this.leafShape = leafShape;
    }

    public boolean isIndoorOnly() {
        return isIndoorOnly;
    }

    public void setIndoorOnly(boolean indoorOnly) {
        isIndoorOnly = indoorOnly;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }
}
