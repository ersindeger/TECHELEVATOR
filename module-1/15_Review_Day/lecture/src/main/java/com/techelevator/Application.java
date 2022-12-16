package com.techelevator;

import java.util.List;

public class Application {

    /**
     * The main entry point in the application
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {

        boolean isRunning = true;
        UI userInterface = new UI();
        HomeInventory inventory = new HomeInventory();

  while (isRunning) {

            int choice = userInterface.printMenu();

            if (choice == 1) {
                List<Home> foundHomes = inventory.retrieveListOfHomes();
                userInterface.printHomes(foundHomes);
            }

            else if (choice == 2) {

                // ask the user for input - MLS id
                System.out.println("Enter an MLS ID");

                // call the inventory class to retrieve home object.
                List<Home> foundHomes = inventory.retrieveListOfHomes();
//                if(foundHomes.


                // send the home object to UI to print

                System.out.println("Search for a home ");
            }
            else if(choice == 3) {
                System.out.println("add a home");
            }
            else if (choice == 4) {
                System.out.println("delete a home");
            }
            else if (choice == 5) {
                isRunning = false;
            }
            else {
                userInterface.printMessage("Invalid Choice");
            }


        }
        System.out.println(" Bye!");





    }


}
