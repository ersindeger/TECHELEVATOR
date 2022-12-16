package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {


        // Create a scanner for user input
        Scanner userInput = new Scanner(System.in);
        // Prompt the user for a word
        System.out.print("What is the search word? ");
        String searchWord = userInput.nextLine();

        System.out.print("What is the replacement word? ");
        String replacementWord = userInput.nextLine();


        System.out.print("What is the source file: ");
        File sourceFile = new File(userInput.nextLine());


        System.out.print("What is the destination file: ");
        File destinationFile = new File(userInput.nextLine());



        /*
        Step 2: Open a file for writing the converted text into it
           Step 2: Open a file for writing the converted text into it
         */

        // Open both the input and output files.

        try (  Scanner fileInput = new Scanner(sourceFile);
               PrintWriter fileOutput = new PrintWriter(destinationFile))
        {

            // Loop until the end of file is reached
            while (fileInput.hasNextLine()) {
                // Read the next line into 'lineOfText'
                String lineOfText = fileInput.nextLine();  //define a String "local variable" LINEOFTEXT

                // Write the text with the replaced word to the output file.
                fileOutput.println(lineOfText.replaceAll(searchWord, replacementWord));
            }
        }

        catch (FileNotFoundException e) {
            // Could not find the file at the specified path.
            System.out.println("The file was not found: " + sourceFile.getAbsolutePath());
        }


    }

}
