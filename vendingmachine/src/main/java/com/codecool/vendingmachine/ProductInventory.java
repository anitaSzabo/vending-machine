package com.codecool.vendingmachine;

import java.util.HashMap;
import java.util.Map;

class ProductInventory {
	
	private Map<Product, Integer> productInventory = new HashMap<>();
	private Map<Product, Integer> productTotalSold = new HashMap<>();
	
	public ProductInventory() {
		productTotalSold.put(Product.COKE, 0);
		productTotalSold.put(Product.PEPSI, 0);
		productTotalSold.put(Product.SODA, 0);
	}
	
	public Map<Product, Integer> getInventory() {
		return productInventory;
	}
	
	public Map<Product, Integer> getTotalSold() {
		return productTotalSold;
	}
	
	public void resupply() {
        productInventory.clear();
        productInventory.put(Product.COKE, 50);
        productInventory.put(Product.PEPSI, 50);
        productInventory.put(Product.SODA, 50);
    }

	public void serve(Product product) {
		if (productInventory.get(product) == null) {
			throw new OutOfStockException();
		}  
		productInventory.put(product, (productInventory.get(product) - 1));
		productTotalSold.put(product, (productTotalSold.get(product) + 1));
	}
}
