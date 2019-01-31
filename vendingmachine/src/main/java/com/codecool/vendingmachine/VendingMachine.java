package com.codecool.vendingmachine;

import java.util.Map;
import java.util.Scanner;

public class VendingMachine 
{
    private CoinTray coinTray;
    private ProductInventory inventory;
    private Scanner reader = new Scanner(System.in);
    private Logger logger = new Logger();
    private boolean productBuyed = false;
    
    public VendingMachine(CoinTray coinTray, ProductInventory inventory) {
    	this.coinTray = coinTray;
    	this.inventory = inventory;
    }
    void start() {
    	logger.logWelcomeMessage();
    	int input = reader.nextInt();
    	Product product = getProductByUserInput(input);
    	buy(product);
   
    }
    
    void buy(Product product) {
    	while(coinTray.calculateBalance() < product.getPrice()) {
    		logger.logTransaction(product.getPrice(), coinTray.calculateBalance());
    		int input = reader.nextInt();
    		if(input == 0) {
    			coinTray.refund();
    			logger.log("Here is your refund: " + coinTray.calculateBalance());
    			break;
    		}
    		Coin.valueOf(input).ifPresent( coin -> {
    			coinTray.insert(coin);
    		});
    	}
    	inventory.serve(product);
    	logger.log("Here is your " + product.name());
    	logger.log("Here is our consumption report: " + inventory.getTotalSold().toString());
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
