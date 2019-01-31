package com.codecool.vendingmachine;

enum Product {
	
	COKE(25),
	PEPSI(35),
	SODA(45);
	
	private int price;
	
	Product(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
}
