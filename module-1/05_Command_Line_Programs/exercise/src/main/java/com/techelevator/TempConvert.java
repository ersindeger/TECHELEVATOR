package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		// This will have one MAIN method,
		// will take in STRING arguments


		Scanner input = new Scanner(System.in); // the SCANNER class here reads
		// the user's entry from the computer and stores it in variable called INPUT.


		System.out.print("Enter the temperature: ");
		// 1. Display a prompt to user to enter something.

		String value = input.nextLine();
		// 2. Use the scanner named "INPUT" to read the STRING the user types..
		// This is assigned to the String which is called "VALUE".

		int temperature = Integer.parseInt(value);
		// 3. Convert STRING "VALUE" into an INT, and store it in a variable called TEMPERATURE.


		System.out.print("Is this in (C)elsius or (F)ahrenheit? ");
		String value2 = input.nextLine();

		char firstLetter = value2.charAt(0);


		double F_temp; double C_temp;

		if ( firstLetter == 'C'){

			F_temp = 1.8 * temperature + 32;
			System.out.println( " The temperature in Fahrenheit is " + F_temp + " degrees." );
			System.out.println( value + " degrees Celsius is equal to " + F_temp + " degrees Fahrenheit" );
		}

		else if ( firstLetter == 'c'){

			F_temp = 1.8 * temperature + 32;
			System.out.println( " The temperature in Fahrenheit is " + F_temp + " degrees." );
			System.out.println( value + " degrees Celsius is equal to " + F_temp + " degrees Fahrenheit" );
		}

		else if ( firstLetter == 'F') {

			C_temp = ( temperature - 32 ) / 1.8;

			System.out.println( " The temperature in Celsius is " + C_temp + " degrees." );
			System.out.println( value + " degrees Fahrenheit is equal to " + C_temp + " degrees Celsius" );
		}

		else if ( firstLetter == 'f') {

			C_temp = ( temperature - 32 ) / 1.8;

			System.out.println( " The temperature in Celsius is " + C_temp + " degrees." );
			System.out.println( value + " degrees Fahrenheit is equal to " + C_temp + " degrees Celsius" );
		}

		else
			System.out.println( "You have entered an invalid entry." );




	}

}
