package com.codecool.vendingmachine;

enum Coin {
	
	PENNY(1),
	NICKEL(5),
	DIME(10),
	QUARTER(25);
	
	int value;
	
	Coin(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
