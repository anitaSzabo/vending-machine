package com.codecool.vendingmachine;

public class VendingMachineApp {
	
	public static void main(String[] args) {
		
		CoinTray coinTray = new CoinTray();
		ProductInventory inventory = new ProductInventory();
		VendingMachine vendingMachine = new VendingMachine(coinTray, inventory);
		
	}
	
}
