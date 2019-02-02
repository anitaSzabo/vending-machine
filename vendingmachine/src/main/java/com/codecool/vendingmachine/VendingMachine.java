package com.codecool.vendingmachine;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class VendingMachine {
	
    private CoinTray coinTray;
    private ProductInventory inventory;
    private Logger logger;
    private InputManager input;
    
    private boolean newTransaction = false;
    private List<Integer> startingOptions = Arrays.asList(1, 2, 3, 4);
    private List<Integer> supplierOptions = Arrays.asList(1, 2, 3);
    private List<Integer> transactionOptions = Arrays.asList(0, 1, 5, 10, 25);
    private List<Integer> finalOptions = Arrays.asList(1);
    
    public VendingMachine(CoinTray coinTray, ProductInventory inventory) {
    	this.coinTray = coinTray;
    	this.inventory = inventory;
    	this.logger = new Logger();
    	this.input = new InputManager(); 
    }
    
    void start() {
    	while (!newTransaction) {
	    	logger.logWelcomeMessage();
	    	int inputNumber = input.verifyInput(startingOptions);
	    	if(inputNumber == 4) {
	    		startSupplierMode();
	    	} else {
		    	Product product = getProductByUserInput(inputNumber);
		    	checkAvailability(product);
		    	startPayingMode(product);
	    	}
    	}
    }
    
	private void startSupplierMode() {
		logger.logSupplierMenu();
		int inputNumber = input.verifyInput(supplierOptions);
		if(inputNumber == 1) {
			inventory.resupply();
			logger.logResupply();
		} else if (inputNumber == 2) {
			logger.logConsumptionReport(inventory.getTotalSold());
		}
		restart();
	}
    
	void startPayingMode(Product product) {
		while(coinTray.calculateBalance() < product.getPrice()) {
			logger.logTransaction(product.getPrice(), coinTray.calculateBalance());
			int inputNumber = input.verifyInput(transactionOptions);
			if(inputNumber == 0) {
				resetTransaction();
				break;
			}
			Coin.valueOf(inputNumber).ifPresent( coin -> {
				coinTray.insert(coin);
			});
		}
		serveProduct(product);
		calculateChange(coinTray.calculateBalance(), product.getPrice());
		restart();
    }
	
	void calculateChange(int balance, int price) {
		int amountOfChange = balance - price;
		Map<Coin, Integer> change = coinTray.getCoins(amountOfChange);
		if(!change.isEmpty()) {
			logger.log("Here is your change " + change.toString());
		}
		
	}

	void resetTransaction() {
		logger.log("Here is your refund: " + coinTray.calculateBalance());
		coinTray.refund();
	}
	
	void serveProduct(Product product) {
		inventory.serve(product);
		logger.log("Here is your " + product.name());
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
    
    void checkAvailability(Product product) {
    	if (inventory.getInventory().get((product)) == 0) {
			throw new OutOfStockException();
		}  
	}
    
    void restart() {
    	logger.logFinalMessage();
    	coinTray.refund();
    	coinTray.clearChange();
    	int number = input.verifyInput(finalOptions);
    }
    
}
