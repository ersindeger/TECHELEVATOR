package com.techelevator;

public abstract class Wall {

    private String color; // the wall test fails when it is NOT marked as private.
    private String name;  // the wall test fails when it is NOT marked as private

    public Wall() {
        
    }

    public Wall(String name, String color, int height, int base) {
    }


    public String getColor() {   //this is GETTER for variable COLOR
        return color;
    }  //getter for variable COLOR.

    public String getName() {  //this is GETTER for variable NAME
        return name;
    }   // getter for variable NAME of the Wall

    public Wall(String name, String color) {
    }

    public abstract int getArea();



}
