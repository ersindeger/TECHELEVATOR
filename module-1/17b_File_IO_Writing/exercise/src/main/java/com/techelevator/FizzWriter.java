package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		System.out.print("What is the destination file: ");
		File destinationFile = new File(userInput.nextLine());

		BufferedWriter outputFile = new BufferedWriter(new FileWriter(destinationFile));


		 outputFile.write("1"); // <=== this silliness because the test requires it to be EXACTLY 300 lines..
									// my loop creates an empty line at the top, so I had to "pull j = 1 out"

		for (int j = 2; j <= 300; j++) {

			if (j % 15 == 0)    { outputFile.write("\nFizzBuzz");  }
			else if (j % 5 == 0) {  outputFile.write("\nBuzz");  }
			else if (j % 3 == 0) {  outputFile.write("\nFizz");   }
			else {   outputFile.write("\n" + j);    }

		}

		outputFile.close();   //     <===   without this, the file gets OVERWRITTEN BLANK!

	}

}
