package com.techelevator;

import java.awt.geom.Area;

public class RectangleWall extends Wall {

    private int length;
    private int height;

    public int getLength() {
        return this.length;
    }

    public int getHeight() {
        return this.height;
    }

    public RectangleWall(String name, String color, int height, int length) {
        super(name, color);
    }


    @Override
    public String toString() {
        String s = "RectangleWall{" +
                + length +
                "x" + height +
                '}';
        return s;
    }

    public String CreateRectangleWall(String name, String color, int length, int height){
        String s = name + " " + length + "x" + height + "rectangle";
        return s;
    }


    @Override
    public int getArea() {
        return 3;
    }
}
