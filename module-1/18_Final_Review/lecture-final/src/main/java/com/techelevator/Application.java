package com.techelevator;

import java.util.List;

public class Application {

    private  UI userInterface = new UI();
    private HomeInventory inventory = new HomeInventory();

    /**
     * The main entry point in the application
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {

        boolean isRunning = true;


        while (isRunning) {

            int choice = userInterface.printMenu();

            if (choice == 1) {
                handleRetrieveListOfHomes();
            }
            else if (choice == 2) {
                handleSearch();
            }
            else if(choice == 3) {
                handleSubMenu();
            }
            else if (choice == 4) {
                handleDeleteHome();
            }
            else if (choice == 5) {
                isRunning = false;
            }
            else {
                userInterface.printMessage("Invalid Choice");
            }

        }
        userInterface.printMessage("Bye!");





    }


    private void handleSubMenu() {

        while (true) {
            int answer = userInterface.printSubMenu();
            if (answer == 1) {
                System.out.println("Owned Home");

                //go ask user to fill out new home info

                // pass the new home info to inventory's addhome()
            }
            else if (answer == 2) {
                System.out.println("Rental Home");

                //go ask user to fill out new rental home info

               // Home newHome = userInterface.askUserForRentalHomeInfo();


                // pass the new home info to inventory's addhome()
               // inventory.addHome(newHome);

            }
            else if (answer == 3) {
                break;
            }
            else {
                userInterface.printMessage("Invalid Choice");
            }


        }
    }

    private void handleDeleteHome() {



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

    private void handleSearch() {

        //ask the user for input - mls id
        String mlsId = userInterface.askForMLSId();

        //call the inventory class to retrieve the home object
        Home foundHome = null;

        try {
            foundHome = inventory.searchByMLSId(mlsId);
        }
        catch (HomeNotFoundException e) {
            userInterface.printMessage(e.getMlsId() + " " + e.getErrorMessage());
        }

        // send the home object to the ui to print
        userInterface.printHome(foundHome);


    }

    private void handleRetrieveListOfHomes() {
        List<Home> foundHomes = inventory.retrieveListOfHomes();
        userInterface.printHomes(foundHomes);
    }


}
