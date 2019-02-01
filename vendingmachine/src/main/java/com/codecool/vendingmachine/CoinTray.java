package com.codecool.vendingmachine;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CoinTray {
	
	private List<Coin> insertedCoins = new ArrayList();
	private Map<Coin, Integer> totalAmountOfCoins = new HashMap<>();
	
	private Map<Coin, Integer> change = new HashMap<>();
	private int remainingChange = 0;
	
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

	public void refund() {
		insertedCoins.clear();
	}
	
	void receiveInsertedCoins() {
		insertedCoins.stream().forEach(i -> totalAmountOfCoins.put(i, totalAmountOfCoins.get(i) + 1));
	}
	
	Map<Coin, Integer> getCoins(int amountOfChange) {
		remainingChange = amountOfChange;
		remainingChange = calculateRemainingChange(remainingChange, Coin.QUARTER);
		remainingChange = calculateRemainingChange(remainingChange, Coin.DIME);
		remainingChange = calculateRemainingChange(remainingChange, Coin.NICKEL);
		remainingChange = calculateRemainingChange(remainingChange, Coin.PENNY);
		
		return change;
	}
	
	int calculateRemainingChange(int remainingChange, Coin coin) {
		int amount = remainingChange/(coin.getValue());
		if(amount != 0) {
			change.put(coin, amount);
		}
		return (remainingChange = remainingChange % coin.getValue());
	}
	
	
}
