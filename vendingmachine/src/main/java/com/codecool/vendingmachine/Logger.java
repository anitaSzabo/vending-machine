package com.codecool.vendingmachine;

import java.util.Map;

public class Logger {
	
	void log(String message) {
		System.out.println(message);
	}

	void logWelcomeMessage() {
		logWelcomeLogo();
		log("\nChoose a product!");
		for(Product product: Product.values()) {
			log((product.ordinal() + 1) + " - " + product.name() + " (" + product.getPrice() + ")");
		}
		log("\n4 - Activate supplier mode");
	}
	
	void logTransaction(int price, int balance) {
		log("Total price: " + price);
		log("Remaining price: " + (price - balance));
		log("Please insert coins! \nYou can choose between 1, 5, 10 and 25.");
		log("Press 0 for cancelling.");
	}
	
	void logSupplierMenu() {
		log("1 - Resupply machine");
		log("2 - Consumption report");
		log("\n3 - Go back");
	}

	public void logConsumptionReport(Map<Product, Integer> totalSold) {
		log("Here is our consumption report: " + totalSold.toString());
		
	}
	
	void logWelcomeLogo() {
		log(" __          __  _                          ");
		log(" \\ \\        / / | |                        "); 
		log("  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___"); 
		log("   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\");
		log("    \\  /\\  /  __/ | (_| (_) | | | | | |  __/");
		log("     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|");                                       
	}

	public void logFinalMessage() {
		log("Press 1 to start a new transaction!");
		
	}
}
