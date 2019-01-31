package com.codecool.vendingmachine;

import java.util.Map;
import java.util.Scanner;

public class VendingMachine 
{
    private CoinTray coinTray;
    private ProductInventory inventory;
    private Scanner reader = new Scanner(System.in);
    
    public VendingMachine(CoinTray coinTray, ProductInventory inventory) {
    	this.coinTray = coinTray;
    	this.inventory = inventory;
    }
    void start() {
    	Logger.log("Welcome! Choose a product!");
    	Logger.log("1 - Coke (25)");
    	Logger.log("2 - Pepsi (35)");
    	Logger.log("3 - Soda (45)");
    	int input = reader.nextInt();
    	Product product = getProductByUserInput(input);
    	buy(product);
   
    }
    
    void buy(Product product) {
    	while(coinTray.calculateBalance() < product.getPrice()) {
    		Logger.log("Total price: " + product.getPrice());
    		Logger.log("Remaining price: " + (product.getPrice() - coinTray.calculateBalance()));
    		Logger.log("Please insert coins! \nYou can choose between 1, 5, 10 and 25.");
    		int input = reader.nextInt();
    		Coin.valueOf(input).ifPresent( coin -> {
    			coinTray.insert(coin);
    		});
    	}
    	Logger.log("Here is your " + product.name());
    	coinTray.calculateChange();
    }
    
    void getConsumptionReport() {
    	Map<Product, Integer> totalSold = inventory.getTotalSold();
    	Logger.log(totalSold.toString());
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
