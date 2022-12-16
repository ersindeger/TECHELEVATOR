package com.techelevator;

public class Elevator {

    private int currentFloor = 1;
    private int numberOfFloors = 3;
    private boolean doorOpen;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public Elevator(int numberOfLevels){
        currentFloor = 1;
    }

    public void openDoor(){
        doorOpen = true;
    }

    public void closeDoor(){
        doorOpen = false;
    }

    public void goUp(int desiredFloor){
        if(!doorOpen){
            if(desiredFloor > 3){
                currentFloor = 3;}
            else if(desiredFloor > currentFloor){
                currentFloor = desiredFloor;
            }
        }
    }

    public void goDown(int desiredFloor){
        if(!doorOpen){
            if(desiredFloor < 1){
                currentFloor = 1;}
            else if(desiredFloor < currentFloor){
                currentFloor = desiredFloor;
            }
        }
    }


}
