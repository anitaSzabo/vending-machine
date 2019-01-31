package com.codecool.vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CoinTray {
	
	private List<Coin> insertedCoins = new ArrayList();
	private Map<Coin, Integer> totalAmountOfCoins = new HashMap<>();
	
	public CoinTray() {
		totalAmountOfCoins.put(Coin.PENNY, 1000);
		totalAmountOfCoins.put(Coin.NICKEL, 1000);
		totalAmountOfCoins.put(Coin.DIME, 1000);
		totalAmountOfCoins.put(Coin.QUARTER, 1000);
	}
	
	public List<Coin> getCoins() {
		return insertedCoins;
	}
	
	public Map<Coin, Integer> getTotalCoins() {
		return totalAmountOfCoins;
	}
	
	public void insert(Coin coin) {
		insertedCoins.add(coin);
	}

	public int calculateBalance() {
		return insertedCoins.stream().mapToInt(Coin::getValue).sum();
	}

	public void clearBalance() {
		insertedCoins.clear();
		
	}
	
	void receiveInsertedCoins() {
		insertedCoins.stream().forEach(i -> totalAmountOfCoins.put(i, totalAmountOfCoins.get(i) + 1));

	}
}
