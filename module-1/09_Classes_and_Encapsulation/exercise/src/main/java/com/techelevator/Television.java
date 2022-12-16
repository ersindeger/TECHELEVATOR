package com.techelevator;

public class Television {

    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;


    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void turnOff(){
        isOn = false;
    }

    public void turnOn(){
        isOn = true;
        currentChannel = 3;
        currentVolume = 2;
    }

    public void changeChannel(int newChannel){

        if(isOn){
            if(currentChannel != newChannel && 3 <= newChannel && newChannel <= 18){
                currentChannel = newChannel;
            }
        }
    }

    public void channelUp(){
        if(isOn){
            if(currentChannel < 18){
                currentChannel = currentChannel + 1;
            }
            else if(currentChannel >= 18)
            { currentChannel = 3;}
        }
    }

    public void channelDown(){
        if(isOn){
            if(currentChannel > 3){
                currentChannel = currentChannel - 1;
            }
            else if(currentChannel == 3)
            { currentChannel = 18;}
        }
    }

    public void raiseVolume(){
        if(isOn){
            if(currentVolume < 10){
                currentVolume = currentVolume + 1;
            }
        }
    }

    public void lowerVolume(){
        if(isOn){
            if(currentVolume >= 1){
                currentVolume = currentVolume - 1;
            }
        }
        else
            currentVolume = currentVolume;
    }


}
