package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		// This will have one MAIN method,
		// will take in STRING arguments


		Scanner input = new Scanner(System.in); // the SCANNER class here reads
		// the user's entry from the computer and stores it in variable called INPUT.


		System.out.print("Enter the length: ");
		// 1. Display a prompt to user to enter something.

		String value = input.nextLine();
		// 2. Use the scanner named "INPUT" to read the STRING the user types..
		// This is assigned to the String which is called "VALUE".

		double length = Double.parseDouble(value);
		// 3. Convert STRING "VALUE" into a DOUBLE, and store it in a variable called LENGTH.


		System.out.print("Is this in (M)eters or (F)eet? ");
		String value2 = input.nextLine();

		char firstLetter = value2.charAt(0);


		double meters_Long; double feet_Long;
		feet_Long = 3.2808399 * length ;
		meters_Long = length * 0.3048 ;


		if ( firstLetter == 'M'){

			System.out.println( " The length is " + feet_Long + " feet." );
			System.out.println( value + " meters is equal to " + feet_Long + " feet" );
		}


		else if ( firstLetter == 'm'){

			System.out.println( " The length is " + feet_Long + " feet." );
			System.out.println( value + " meters is equal to " + feet_Long + " feet" );
		}


		else if ( firstLetter == 'F') {

			System.out.println( " The length is " + meters_Long + " meters." );
			System.out.println( value + " feet is equal to " + meters_Long + " meters" );
		}


		else if ( firstLetter == 'f') {

			System.out.println( " The length is " + meters_Long + " meters." );
			System.out.println( value + " feet is equal to " + meters_Long + " meters" );
		}

		else
			System.out.println( "You have entered an invalid entry." );


	}


}

