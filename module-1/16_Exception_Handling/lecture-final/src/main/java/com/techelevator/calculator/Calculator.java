package com.techelevator.calculator;

public class Calculator {

    public int divide (int x, int y) {

        int a = 0;

        try {
           a = x / y;
           if (a == 2) {
               throw new SteveException();
           }
        }
        catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("You can't do that!");
        }
        catch (SteveException e) {
            e.printStackTrace();
            System.out.println(e.getStevesSpecialMessage());
        }

       return a;

    }

}
