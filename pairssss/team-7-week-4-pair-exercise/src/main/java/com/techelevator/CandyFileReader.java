package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CandyFileReader {

    private File inventoryFile = new File("inventory.csv");

    public Map<String, Candy> loadCandy() {

        Map<String, Candy> candyMap = new TreeMap<>();

        try {
            Scanner fileScanner = new Scanner(inventoryFile);
            while (fileScanner.hasNextLine()){

                String candyInfo = fileScanner.nextLine();

                String[] splitCandyInfo = candyInfo.split("\\|");

                Candy candy = null;

                if (splitCandyInfo[0].equals("CH")) {
                    candy = new Chocolates();
                }
                else if (splitCandyInfo[0].equals("SR")) {
                    candy = new Sours();
                }
                else if (splitCandyInfo[0].equals("HC")) {
                    candy = new HardCandy();
                }
                else if (splitCandyInfo[0].equals("LI")) {
                    candy = new Licorice();
                }

                candy.setProductCategory(splitCandyInfo[0]);
                candy.setProductId(splitCandyInfo[1]);
                candy.setName(splitCandyInfo[2]);
                candy.setPrice(Double.parseDouble(splitCandyInfo[3]));
                candy.setHasWrapper(splitCandyInfo[4].equals("T"));
                candy.setQty(100);

                candyMap.put(candy.getProductId(), candy);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return candyMap;

    }
}
