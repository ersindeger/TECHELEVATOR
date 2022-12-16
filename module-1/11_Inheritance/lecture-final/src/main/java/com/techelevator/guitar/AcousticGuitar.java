package com.techelevator.guitar;

public class AcousticGuitar extends Guitar{

    private String color;

    public AcousticGuitar(int numberOfStrings) {
        super(numberOfStrings);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
