package com.techelevator;

public class Payroll {


    public static void main(String[] args) {

        int hoursWorked = 50;
        double payRate = 70.20;
        boolean isHourly = false;

        if (hoursWorked <= 40 && isHourly) {
            //calculate pay for hourly worker without OT
            double pay = hoursWorked * payRate;
            System.out.println("Hours Worked: " + hoursWorked + ", Pay Rate: " + payRate + " paycheck should be = " + pay);

        }
        else if (hoursWorked > 40 && isHourly) {

            int overtimeHours = hoursWorked - 40;
            double overTimePay =  (overtimeHours * payRate) * 1.5;
            double regularPay = 40 * payRate;
            double pay = regularPay + overTimePay;
            System.out.println("Paycheck should be = " + pay);
        }
        else {
            //assume salaried
            System.out.println("You work for free");
        }





    }


}
