package com.codecool.vendingmachine;

import java.util.Map;
import java.util.Scanner;

public class VendingMachine 
{
    private CoinTray coinTray;
    private ProductInventory inventory;
    private Scanner reader;
    private Logger logger;
    private InputManager input;
    private boolean productPayed = false;
    
    public VendingMachine(CoinTray coinTray, ProductInventory inventory) {
    	this.coinTray = coinTray;
    	this.inventory = inventory;
    	this.reader = new Scanner(System.in);
        this.logger = new Logger();
        this.input = new InputManager(); 
    }
    
    void start() {
    	logger.logWelcomeMessage();
    	int inputNumber = input.verifyStartingInput();
    	if(inputNumber == 4) {
    		startSupplierMode();
    	} else {
	    	Product product = getProductByUserInput(inputNumber);
	    	startPayingMode(product);
    	}
    }
    
    private void startSupplierMode() {
		logger.logSupplierMenu();
		int inputNumber = input.verifySupplierInput();
		if(inputNumber == 1) {
			inventory.resupply();
		} else if (inputNumber == 2) {
			logger.logConsumptionReport(inventory.getTotalSold());
		}
	}
    
	void startPayingMode(Product product) {
    	while(coinTray.calculateBalance() < product.getPrice()) {
    		logger.logTransaction(product.getPrice(), coinTray.calculateBalance());
    		int inputNumber = input.verifyTransactionInput();
    		if(inputNumber == 0) {
    			resetTransaction();
    			break;
    		}
    		Coin.valueOf(inputNumber).ifPresent( coin -> {
    			coinTray.insert(coin);
    		});
    	}
    	serveProduct(product);
    }
	
	private void resetTransaction() {
		logger.log("Here is your refund: " + coinTray.calculateBalance());
		coinTray.refund();
	}
	
	void serveProduct(Product product) {
		inventory.serve(product);
    	logger.log("Here is your " + product.name());
    	coinTray.calculateChange();
	}
    
    void getConsumptionReport() {
    	Map<Product, Integer> totalSold = inventory.getTotalSold();
    	logger.log(totalSold.toString());
    }
    
    Product getProductByUserInput(int number) {
    	if (number == 1) {
    		return Product.COKE;
    	} else if (number == 2) {
    		return Product.PEPSI;
    	} else {
    		return Product.SODA;
    	}
    }
    
}
