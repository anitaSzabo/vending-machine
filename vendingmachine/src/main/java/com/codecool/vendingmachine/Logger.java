package com.codecool.vendingmachine;

public class Logger {
	
	void log(String message) {
		System.out.println(message);
	}

	void logWelcomeMessage() {
		log("Welcome! Choose a product!");
    	log("1 - Coke (25)");
    	log("2 - Pepsi (35)");
    	log("3 - Soda (45)");
	}
	
	void logTransaction(int price, int balance) {
		log("Total price: " + price);
		log("Remaining price: " + (price - balance));
		log("Please insert coins! \nYou can choose between 1, 5, 10 and 25.");
		log("Press 0 for cancelling.");
	}
}
