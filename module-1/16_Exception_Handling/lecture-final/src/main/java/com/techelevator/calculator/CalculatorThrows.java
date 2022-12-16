package com.techelevator.calculator;

public class CalculatorThrows {

    public int divide (int x, int y) throws SteveException{

        int a = 0;

            a = x / y;
            if (a == 2) {
                throw new SteveException();
            }

        return a;

    }

}
