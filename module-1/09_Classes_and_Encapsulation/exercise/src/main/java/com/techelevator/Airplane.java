package com.techelevator;

public class Airplane {

    public Airplane () {}

    int availableCoachSeats;

    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    private int availableFirstClassSeats;

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableFirstClassSeats() {
        return availableFirstClassSeats;
    }

    public int getAvailableCoachSeats() {
        return availableCoachSeats;
    }





    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats){
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
        availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
        availableCoachSeats = totalCoachSeats - bookedCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats){

        if(forFirstClass && availableFirstClassSeats >= totalNumberOfSeats){
            bookedFirstClassSeats = bookedFirstClassSeats + totalNumberOfSeats;
            return true;
        }
        else if (forFirstClass && availableFirstClassSeats < totalNumberOfSeats){
            availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
            return false;
        }
        else if (!forFirstClass && availableCoachSeats >= totalNumberOfSeats){
            bookedCoachSeats = bookedCoachSeats + totalNumberOfSeats;
            availableCoachSeats = availableCoachSeats - totalNumberOfSeats;
            return true;
        }
        else {
            availableCoachSeats = totalCoachSeats - bookedCoachSeats;
            return false;
        }

    }



}
