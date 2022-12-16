package com.techelevator;

public class Plant {

    private String color;
    private String leafShape;
    private boolean InDoorOnly;
    private String plantName;

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

    public boolean isDoorOnly() {
        return InDoorOnly;
    }

    public void setDoorOnly(boolean doorOnly) {
        InDoorOnly = doorOnly;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantNames) {
        this.plantName = plantNames;
    }
}
