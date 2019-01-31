package com.codecool.vendingmachine;

import java.util.Map;

public class VendingMachine 
{
    private CoinTray coinTray;
    private ProductInventory inventory;
    
    public VendingMachine(CoinTray coinTray, ProductInventory inventory) {
    	this.coinTray = coinTray;
    	this.inventory = inventory;
    }
    
    Map<Product, Integer> getConsumptionReport() {
    	Map<Product, Integer> totalSold = inventory.getTotalSold();
    	return totalSold;
    }
    
}
