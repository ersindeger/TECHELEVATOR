package com.techelevator;

public class TriangleWall extends Wall{
    public TriangleWall(String name, String color) {
        super(name, color);
    }

    public TriangleWall(String name, String color, int height, int base) {
        super(name, color, height, base);
    }

    @Override
    public int getArea() {
        return 3;
    }

    public int GetAreaRoundsDown() {return 4;}
}
