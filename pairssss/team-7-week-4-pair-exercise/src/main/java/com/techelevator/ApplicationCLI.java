package com.techelevator;


import java.util.List;

public class ApplicationCLI {

	private UserInterface ui = new UserInterface();
	private CandyInventory candyInventory = new CandyInventory();
	private Cashbox cashbox = new Cashbox();
	private ShoppingCart shoppingCart = new ShoppingCart();
	private FileWriterForCandy fileWriter = new FileWriterForCandy();

	public static void main(String[] args) {
		ApplicationCLI cli = new ApplicationCLI();
		cli.run();
	}

	public void run() {

		boolean isRunning = true;

		while (isRunning) {

			int selection = ui.printMainMenu();

			if (selection == 1) {
				List<Candy> candyList = candyInventory.retrieveListOfCandy();
				ui.printCandy(candyList);
			}
			else if ( selection == 2 ) {

				while (true) {

					int answer = ui.printSubmenu();

					if (answer == 1) {
						ui.displayCurrentBalance(cashbox.getCustomerBalance());

						int depositAmount = ui.askForDepositAmount();

						if (cashbox.getCustomerBalance() + depositAmount > 1000) {
							ui.printMessage("Balance cannot be more than $1000.");
						} else if (depositAmount > 100 || depositAmount < 0) {
							ui.printMessage("Unable to deposit more than $100 or a negative amount.");
						} else {
							cashbox.addToBalance(depositAmount);
							fileWriter.logMoneyReceived(cashbox.getCustomerBalance() - depositAmount, cashbox.getCustomerBalance());
							ui.displayCurrentBalance(cashbox.getCustomerBalance());
						}
					} else if (answer == 2) {
						List<Candy> candyList = candyInventory.retrieveListOfCandy();
						ui.printCandy(candyList);

						String productId = ui.checkId();
						int requestedQty = ui.requestedQty();

						if (!candyInventory.containsProductId(productId)) {
							ui.printMessage("Product ID does not exist.");
						} else if (!candyInventory.hasStock(productId)) {
							ui.printMessage("Product is sold out.");
						} else if (!candyInventory.hasEnoughQty(productId, requestedQty)) {
							ui.printMessage("Insufficient stock.");
						} else if (candyInventory.calculateCostOfCandyQty(productId, requestedQty) > cashbox.getCustomerBalance()) {
							ui.printMessage("Insufficient funds.");
						} else {
							Candy candy = new Candy();
							candy.setProductId(productId);
							candy.setQty(requestedQty);
							candy.setName(candyInventory.retrieveName(productId));
							candy.setPrice(candyInventory.calculateCostOfCandyQty(productId, requestedQty));
							candy.setProductCategory(candyInventory.retrieveCategory(productId));

							fileWriter.logItemsOrdered(candy, cashbox.getCustomerBalance());

							System.out.println("The shopping cart now is updated");
							cashbox.subtractFromBalance(candyInventory.calculateCostOfCandyQty(productId, requestedQty));
							ui.displayCurrentBalance(cashbox.getCustomerBalance());

							shoppingCart.addToShoppingCart(candy);
							candyInventory.takeItemOutOfInventory(productId, requestedQty);
						}
					} else if (answer == 3) {
						List<Integer> changeList = cashbox.giveChange();
						List<Candy> shoppingList = shoppingCart.getShoppingCart();

						double finalCustomerChange = cashbox.getCustomerBalance();
						double totalAmount = shoppingCart.getTotalShoppingCartAmount(shoppingList);

						fileWriter.logChangeGiven(cashbox.getCustomerBalance());

						ui.printReceipt(shoppingList);
						ui.printCartTotal(totalAmount);
						ui.printChange(changeList, finalCustomerChange);

						fileWriter.writeToLog();
						cashbox.resetBalanceToZero();
						shoppingCart.resetShoppingCart();

						break;
					} else {
						ui.printMessage("Invalid choice.");
					}
				}
			}
			else if (selection == 3) {
				ui.printMessage("Enjoy your candy!");
				isRunning = false;
			}
			else {
				ui.printMessage("Invalid choice.");
			}
		}
	}
}
