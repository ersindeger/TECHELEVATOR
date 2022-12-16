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

                //ask the user for input - mls id
                String mlsId = userInterface.askForMLSId();

                //call the inventory class to retrieve the home object
                Home foundHome = inventory.searchByMLSId(mlsId);

                // send the home object to the ui to print
                userInterface.printHome(foundHome);

                System.out.println("Search for a home ");
            }
            else if(choice == 3) {
                System.out.println("add a home");
            }
            else if (choice == 4) {
                System.out.println("delete a home");

                //ask user for mlsid
                String mlsId = userInterface.askForMLSId();

                //go delete it in the inventory
                if (inventory.deleteHome(mlsId)) {
                    userInterface.printMessage("Home " + mlsId + "was deleted");
                }
                else {
                    userInterface.printMessage("Home was deleted or not found");
                }



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
