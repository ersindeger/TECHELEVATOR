package com.techelevator.calculator;

public class CalculatorApp {

    public static void main(String[] args) {


        UserInterface ui = new UserInterface();
        //Calculator calculator = new Calculator();
        CalculatorThrows calculatorThrows = new CalculatorThrows();



        Numbers nums = ui.getNumbers();



        int result = 0;

        try {
            result = calculatorThrows.divide(nums.getNum1(), nums.getNum2());
        }
        catch (SteveException e) {
            ui.printMessage("A steve exception occurred, you would be better off hiring Brian! Actual EX: " + e.getStevesSpecialMessage() );
        }
        catch (ArithmeticException e) {
            ui.printMessage(e.getMessage());
        }
        catch (Exception e) {
            ui.printMessage("Generic Error. Please contact support!");
        }


        System.out.println(result);





    }


}
