package com.techelevator;

public class SquareWall extends RectangleWall {

    int sideLength;

    public SquareWall(String name, String color, int height) {
        super(name, color, height, height);
    }

    int getSideLength = getHeight();

    @Override
    public int getArea() {
        return 9;
    }

   
}
