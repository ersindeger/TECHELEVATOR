package com.techelevator;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello!!!");
        int age=16; //variable declaration
        long spaceAge= 1434832; //variable assignment

        float payRate = 3.234234398823f;
        System.out.println(payRate);

        String studentName = "Ersin";

        int currentMonth = 9;

        int price = 5;

        int quantity = 3;

        int total = price * quantity;
        System.out.println("The total amount comes out to " + total + " dollars.\n\n"
                + "oh boy... this was expensive!");
        System.out.println("Thank you");

        char c = 'c';

        long val1 = 657765675;
        double someNum = (int) val1;
        int quotient = price / quantity;
        int kalan = price%quantity;

        System.out.println("you get " + quotient + " item" + " and there will be left  $" + kalan);



    }
}
