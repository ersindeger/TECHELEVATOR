package com.techelevator;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter a non-negative integer  ");

		String value = input.nextLine(); //read and store that STRING entry and call that "value"

		int fibonacciEndsNoMoreThan = Integer.parseInt(value); // convert STRING into INT

		int fib0 = 0; int fib1 = 1;

		int fib2 = 1;


		if (fibonacciEndsNoMoreThan <= 0){      //if the user entry is 0 or less, it will spit
										// out the first two terms in Fibonacci.
			System.out.print("0, 1");
		}

		else {

			while (fib0 <= fibonacciEndsNoMoreThan) {  // Iterate till fibonacci term is <= user entry
											// The upper bound is chosen sufficiently large to create a loop.

				// Print the number
				System.out.print(fib0 + "  ");


				// The recurrence formula is:   a_(n+2) = a_(n+1) + a_(n),
				// Notice, due to the formula, how a Fibonacci can be considered as "triplets"
				//  a_(n), a_(n+1), a_(n+2) where the LAST TERM in this triplet is the sum of the first two.
				// This is true for ALL n >= 0. This provides us with a critical idea to iterate the loop above!
				// So we proceed with the critical swaps described below....

				fib0 = fib1;  // This is the crucial first step within the loop. This replaces the
							// value of FIB0 with  FIB1,

				fib1 = fib2;  // This is the crucial second step in the loop. It replaces the value of
							// FIB1 with FIB2.

				fib2 = fib0 + fib1;  // The previous two steps will spit out a bigger value for FIB2.
								// and the WHILE loop keeps rolling.
								//observe the WHILE loop will stop precisely when
								// FIB0 is bigger than the user entry (although bigger values
								// of FIB1 and FIB2 are calculated along the process.

			}

		}


	}

}
