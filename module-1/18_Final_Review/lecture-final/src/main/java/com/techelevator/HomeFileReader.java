package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HomeFileReader {

    private File inventoryFile = new File("homes.csv");


    public Map<String, Home> loadHomes() {
        Map<String, Home> homesMap = new HashMap<>();

        try {
            Scanner fileScanner = new Scanner(inventoryFile);
            while (fileScanner.hasNextLine()) {

                String record = fileScanner.nextLine();

                String[] fields = record.split(",");

                Home home = null;

                if (fields[0].equals("O")) {
                    home = new OwnedHome();
                }
                else {
                    home = new RentalHome();
                }

                home.setMlsId(fields[1]);
                home.setNumberOfBedrooms(Integer.parseInt(fields[2]));
                home.setNumberOfBathrooms(Double.parseDouble(fields[3]));
                home.setSquareFeet(Integer.parseInt(fields[4]));
                home.setListingPrice(Double.parseDouble(fields[5]));

                Address address = new Address();
                address.setAddressLine1(fields[6]);
                address.setCity(fields[7]);
                address.setState(fields[8]);
                address.setZip(fields[9]);

                home.setAddress(address);

                home.setDescription(fields[10]);

                homesMap.put(home.getMlsId(), home);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        return homesMap;
    }







}
