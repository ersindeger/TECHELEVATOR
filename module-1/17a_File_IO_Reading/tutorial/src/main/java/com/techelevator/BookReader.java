package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookReader {
    static private final String BEGIN_MARKER = "*** START OF";
    static private final String END_MARKER = "*** END OF";
    public static void main(String[] args) {
        /*
         * This book-reader program opens a file that was downloaded from https://www.gutenberg.org/, reads
         * through the copyright information at the top until it finds the start of the book content, and
         * then displays the content to the user. It also counts the total lines of book content between the
         * start and the end markers.
         */

        /*
        Step 1: Prompt the user for a filename
         */
        // Create a scanner for user input
        Scanner userInput = new Scanner(System.in);
        // Prompt the user for a file path - path should look like "data\jekyll-and-hyde.txt"
        System.out.print("Enter path to the book file: ");
        String filePath = userInput.nextLine();

        /*
        Step 2: Step Two: Open the book file and handle errors
         */
        // Create a File object using the path
        File bookFile = new File(filePath);


        int lineCount = 0;          // Count of lines between the start and end markers.

        // Open the file
        try (Scanner fileInput = new Scanner(bookFile)) {

            // Loop until the end of file is reached
            while (fileInput.hasNextLine()) {
                // Read the next line into 'lineOfText'
                String lineOfText = fileInput.nextLine();
                // Increment the line count.
                lineCount++;
                // Print the line
                System.out.println(lineCount + ": " + lineOfText);
            }

        } catch (FileNotFoundException e) {
            // Could not find the file at the specified path.
            System.out.println("The file was NOT found: " + bookFile.getAbsolutePath());
                                            //getAbsolutePath method shows the file path

            // when you enter something like data/sherlock-holmes.txt, it WILL find the  book and NOT generate any type
            // of errors.  data/  ===> is the folder under TUTORIAL where there is such a file.
        }

        // Tell the user how many lines of content were found.
        System.out.println();
        System.out.println("Found " + lineCount + " lines of text in " + filePath);


    }
    
}
