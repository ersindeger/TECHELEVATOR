package com.techelevator;

public class Exercise05_Weather {

    private final static int FREEZING_TEMPERATURE = 32;

    /*
    GaleForce Meteorologists recently developed a new weather station and need it to perform
    some common measurements for reporting.

    Note: Assume all temperatures are in Fahrenheit (°F) unless otherwise
    noted.
     */

    /*
    GaleForce needs to know the number of days in the upcoming forecast
    where the temperature is at or below freezing.

    Given an array of high temperatures, count the number of days when
    the high temperature is freezing (32° F) or below.

    Examples:
	belowFreezing([33, 30, 32, 37, 44, 31, 41]) → 3
	belowFreezing([-7, -3, 19, 35, 30])  → 4
	belowFreezing([]) → 0
    */
	public int belowFreezing(int[] dailyHighs)
    {

            int i;
            int counterOfDays = 0;


            // Go through array elements from first and
            // keep track of if:    32 - daily high >= 0
            for (i = 0; i <= dailyHighs.length - 1; i++) {

                if (FREEZING_TEMPERATURE - dailyHighs[i] >=  0) {
                    counterOfDays = counterOfDays + 1;
                }


            }
        return counterOfDays;

	}

    /*
    GaleForce also needs to determine the hottest day when given an upcoming forecast.

    Given an array of high temperatures, determine the hottest temperature.

    Note: The array of high temperatures is guaranteed to have at least one
    element.

    Examples:
	hottestDay([81, 93, 94, 105, 99, 95, 101, 90, 89, 92]) → 105
	hottestDay([23, 24] → 24
	hottestDay([34, 33] → 34
	hottestDay([55]) → 55
    */
    public int hottestDay(int[] dailyHighs)
    {

        int i;

        // Initialize maximum temperature to be the first day of the array.
        int maximumValue = dailyHighs[0];

        // Go through array elements starting from second and
        // compare every element with the "current maximum temperature"
        for (i = 1; i < dailyHighs.length; i++) {

            if (dailyHighs[i] > maximumValue)
                maximumValue = dailyHighs[i];

        }

        return maximumValue;

    }

    /*
    GaleForce discovered an equipment malfunction. Every other reading, starting with the first,
    was off by 2 degrees Fahrenheit (°F).

    Given an array of Fahrenheit temperatures, fix each of the incorrect readings by adding
    2 degrees to its current value.

    Examples:
	fixTemperatures([33, 30, 32, 37, 44, 31, 41]) → [35, 30, 34, 37, 46, 31, 43]
	fixTemperatures([-7, -33, 19, 35]) → [-5, -33, 21, 35]
	fixTemperatures([-1, 0, 1] → [1, 0, 3]
    fixTemperatures([-1] → [1]
	fixTemperatures([]) → []
     */

    public int[] fixTemperatures(int[] temperatures) {

        int [] correctedTemps = new int[temperatures.length];
        // this sets up an array named "CorrectedTemps" that is as long as the "Temperatures" array.

        for (int i = 0; i < temperatures.length; i ++) {
            correctedTemps[i] = temperatures[i];
        }  //this initially sets all elements of "CorrectedTemps" to be equal to the "Temperatures".


        for (int i = 0; i < temperatures.length; i += 2) {
            correctedTemps[i] = correctedTemps[i] + 2;
        }  //this increases the FIRST reading in this new array (and EVERY OTHER entry after that) by +2.

        return correctedTemps;
    }
}
