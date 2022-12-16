package com.techelevator.tenmo;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserCredentials;
import com.techelevator.tenmo.services.*;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
    private final UserService userService = new UserService(API_BASE_URL);
    private final TransferService transferService = new TransferService(API_BASE_URL);

    private AuthenticatedUser currentUser;

    public static void main(String[] args) {
        App app = new App();
        app.run();

    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
    }

    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials(); //stores user entered LOGIN and PWD as CREDENTIALS
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        }
        else {
            userService.setAuthToken(currentUser.getToken());
            transferService.setAuthToken(currentUser.getToken());
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                viewCurrentBalance();
            } else if (menuSelection == 2) {
                viewTransferHistory();
            } else if (menuSelection == 3) {
                viewPendingRequests();
            } else if (menuSelection == 4) {
                sendBucks();
            } else if (menuSelection == 5) {
                requestBucks();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

	private void viewCurrentBalance() {
		// TODO Auto-generated method stub
        BigDecimal balance = userService.getUserBalance();
        consoleService.printBalance(balance);
	}

	private void viewTransferHistory() {
        List<Transfer> transfers = null;
        Transfer transfer = null;

        try {
            transfers = transferService.retrieveAllTransfers();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        consoleService.printTransfers(transfers);

        consoleService.pause();

        while (true) {
            int transferId = consoleService.promptForInt("Enter Transfer Id for more details: ");

            try {
                transfer = transferService.retrieveTransferByTransferId(transferId);
                if(transfer != null) { break; }
            } catch (ServiceException e) {
                e.printStackTrace();
                consoleService.printMessage("Enter a VALID TRANSFER ID");
            }
        }

        if (transfer.getTransferStatus() == 2) {
            transfer.setTransferStatusMessage("Approved");
        }
        if (transfer.getTransferType() == 2) {
            transfer.setTransferTypeMessage("Sent");
        }

        consoleService.printTransferId(transfer);
    }
        // TODO ABOVE Auto-generated method stub


	private void viewPendingRequests() {
		// TODO Auto-generated method stub
		consoleService.printMessage("You have no pending requests.");
	}

	private void sendBucks()  {
        Transfer transfer = new Transfer();
        List<User> users = null;
        try {
            users = userService.retrieveAllUsers();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        consoleService.printUsers(users);

		// TODO Auto-generated method stub

        int UserIdTo = consoleService.getUserIdTo();


        while (true) {
            BigDecimal AmountToBeTransferred = consoleService.getAmount();

            if( (userService.getUserBalance().compareTo(AmountToBeTransferred) < 0))
            {consoleService.printMessage("The Amount to be sent CANNOT be more than your account balance.");}

            else if ( AmountToBeTransferred.compareTo(BigDecimal.ZERO) <= 0 )
            {consoleService.printMessage("The Amount to be sent CANNOT be zero or negative!!");}

            else {
                transfer.setUserIdTo(UserIdTo);
                transfer.setAmount(AmountToBeTransferred);
                transfer.setUserIdFrom(currentUser.getUser().getId());

                transferService.createTransfer(transfer); break;}
        }

        consoleService.printMessage("Transaction completed. View your past transfers  (Option 2 / Menu)  for transaction details.");
	}


	private void requestBucks() {
		// TODO Auto-generated method stub
		consoleService.printMessage("You really should not be asking for money from other people :/ ");
	}

}
