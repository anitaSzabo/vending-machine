package com.codecool.vendingmachine;

import java.util.Arrays;

import java.util.Optional;

enum Coin {
	
	PENNY(1),
	NICKEL(5),
	DIME(10),
	QUARTER(25);
	
	private final int value;
	
	Coin(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static Optional<Coin> valueOf(int value) {
			return Arrays.stream(values())
				.filter(Coin -> Coin.value == value)
				.findFirst();
    }
}
