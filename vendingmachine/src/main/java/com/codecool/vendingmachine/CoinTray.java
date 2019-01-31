package com.codecool.vendingmachine;

import java.util.ArrayList;
import java.util.List;

class CoinTray {
	
	private List<Coin> insertedCoins = new ArrayList();
	
	public void add(Coin coin) {
		insertedCoins.add(coin);
	}
	
	public List<Coin> getCoins() {
		return insertedCoins;
	}

	public int calculateBalance() {
		return insertedCoins.stream().mapToInt(Coin::getValue).sum();
	}

	public void clearBalance() {
		insertedCoins.clear();
		
	}
}
