package com.codecool.vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoinTrayTest {
	
private CoinTray coinTray;
	
	@BeforeEach
    public void setup() {
        coinTray = new CoinTray();
    }
	
	@Test
	public void testCoinTrayExists() {
		assertThat(coinTray).isNotNull();
	}
	
	@Test
	public void testIfEmptyCoinTrayReceivesCoin() {
		coinTray.insert(Coin.PENNY);
		
		assertEquals(Coin.PENNY.getValue(), coinTray.getCoins().get(0).getValue());
	}
	
	@Test
	public void testIfCoinTrayGivesBackBalance() {
		coinTray.insert(Coin.PENNY);
		coinTray.insert(Coin.DIME);
		coinTray.insert(Coin.DIME);
		
		assertEquals(21, coinTray.calculateBalance());
	}
	
	@Test
	public void testIfCoinTrayGivesBackBalanceIfBalanceIsNull() {
		assertEquals(0, coinTray.calculateBalance());
	}
	
	@Test
	public void testIfCoinTrayClearsUserBalance() {
		coinTray.insert(Coin.PENNY);
		coinTray.insert(Coin.DIME);
		coinTray.insert(Coin.QUARTER);
		coinTray.refund();
		
		assertEquals(0, coinTray.calculateBalance());
	}
	
	@Test
	public void testIfCoinTrayReceivesCoinsAfterClearingUserBalance() {
		coinTray.insert(Coin.PENNY);
		coinTray.insert(Coin.DIME);
		coinTray.insert(Coin.QUARTER);
		coinTray.refund();
		coinTray.insert(Coin.QUARTER);
		
		assertEquals(25, coinTray.calculateBalance());
	}
	
	@Test
	public void testIfInsertedCoinsAreAddedToTotal() {
		coinTray.insert(Coin.PENNY);
		coinTray.insert(Coin.DIME);
		coinTray.insert(Coin.DIME);
		coinTray.receiveInsertedCoins();
		
		assertEquals(1002, coinTray.getTotalCoins().get(Coin.DIME));
	}
	
	@Test
	public void testIfCoinTrayGivesBackChange() {
		Map<Coin, Integer> coins = new HashMap<>();
		coins.put(Coin.DIME, 1);
		coins.put(Coin.NICKEL, 1);
		
		assertEquals(coins, coinTray.getCoins(15));
	}
	
	@Test
	public void testIfCoinTrayGivesBackChangeIfChangeIs0() {
		Map<Coin, Integer> coins = new HashMap<>();
		
		assertEquals(coins, coinTray.getCoins(0));
	}
}
