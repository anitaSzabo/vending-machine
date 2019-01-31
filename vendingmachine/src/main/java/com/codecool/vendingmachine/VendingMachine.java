package com.codecool.vendingmachine;

import java.util.Map;

public class VendingMachine 
{
    private CoinTray coinTray;
    private ProductInventory inventory;
    
    public VendingMachine() {
    	coinTray = new CoinTray();
    	inventory = new ProductInventory();
    }
    
    Map<Product, Integer> getConsumptionReport() {
    	Map<Product, Integer> totalSold = inventory.getTotalSold();
    	return totalSold;
    }
    
}
