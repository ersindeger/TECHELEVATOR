package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FileSplitter {

	public static void main(String[] args) throws IOException {

		PrintWriter outputFile = new PrintWriter(new FileWriter("OutputFileSplitter.txt"));
		outputFile.write("yo! whats up?");
		outputFile.close();   //     <===   without this, the file gets OVERWRITTEN BLANK!

	}


}
