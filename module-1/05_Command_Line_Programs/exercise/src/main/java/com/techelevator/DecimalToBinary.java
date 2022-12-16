package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); // the SCANNER class here reads
		// the user's entry from the computer and stores it in variable called INPUT.


		System.out.print("Enter whole numbers (i.e. integers base 10) separated by space: ");
		// Display a prompt to user to enter something.


		String allEntries = input.nextLine();
		// Use the scanner named "USER_ENTRY" to read the STRING the user types..
		// and this is stored in variable named VALUE as a STRING.

		String[] strings = allEntries.split(" ");
		//   .split  replaces the spaces in between the numbers by the user entry, and
		// defines it as a new string called STRING_OF_NUMBERS

		int[] number = new int[strings.length];

		for (int z = 0; z < strings.length; z++) {
			number[z] = Integer.parseInt(strings[z]);
		}

			for (int j = 0; j < strings.length; j++) {
				int n = 0;

				while (Math.pow(2, n) <= number[j]) {
					n = n + 1;
				} // n determines how many digits will number[j] will be

//
//

				int quotient;
//			for (int i = 0; i <= n; i++) {
//
//				quotient = arrayOfNumbersByUser[j] / 2;
//
//				remainder = arrayOfNumbersByUser[j] % 2;
//
//				arrayOfNumbersByUser[j] = quoti
				int[] remainder = new int[n];

				for (int i = 0; i < n; i++) {

					quotient = number[j] / 2;

					remainder[i] = number[j] % 2;

					number[j] = quotient;

				}
//
//				for (int element : remainder) {
//					System.out.print(element);
//				}
				for (int x = 0; x < n; x++) {
					System.out.print(remainder[n - 1 - x]);
				}

				System.out.println();
				System.out.println();
			}

//		}
//
//
//
////		int wholeNumber = Integer.parseInt(stringOfUserEntry);
////		// convert the String VALUE into an int called WHOLE_NUMBER.
////
////
////
////
////
////		int n = 0;
////		int count = 0;
////		while( Math.pow(2,n) <= wholeNumber ) {
////			count = count + 1;
////			n = n + 1;
////		}
////
////
////		int[] remainder = new int[count];
////		int quotient = 2;
////		int i = 0;
//
////			for (int i = 0; i <= remainder.length; i++) {
////
////				quotient = wholeNumber / 2;
////
////				remainder[i] = wholeNumber % 2;
////
////				wholeNumber = quotient;
//
////			while (quotient >=2 ){
////
////				quotient = wholeNumber / 2 ;
////
////				remainder[i] = wholeNumber % 2;
////
////				wholeNumber = quotient ;
////
////				System.out.print(remainder[i]);
////
////			}
////
////			if (wholeNumber == 1) {
////				System.out.print("1");
////				remainder[remainder.length] = 1;
////			}


		}

	}






