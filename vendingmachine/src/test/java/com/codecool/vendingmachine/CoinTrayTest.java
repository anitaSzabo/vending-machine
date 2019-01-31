package com.codecool.vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;

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
		coinTray.add(Coin.PENNY);
		
		assertEquals(Coin.PENNY.value, coinTray.getCoins().get(0).value);
	}
	
	@Test
	public void testIfCoinTrayGivesBackBalance() {
		coinTray.add(Coin.PENNY);
		coinTray.add(Coin.DIME);
		coinTray.add(Coin.DIME);
		
		assertEquals(21, coinTray.calculateBalance());
	}
	
	@Test
	public void testIfCoinTrayGivesBackBalanceIfBalanceIsNull() {
		assertEquals(0, coinTray.calculateBalance());
	}
	
	@Test
	public void testIfCoinTrayClearsBalance() {
		coinTray.add(Coin.PENNY);
		coinTray.add(Coin.DIME);
		coinTray.add(Coin.QUARTER);
		coinTray.clearBalance();
		
		assertEquals(0, coinTray.calculateBalance());
	}
	
	@Test
	public void testIfCoinTrayReceivesCoinsAfterClearingBalance() {
		coinTray.add(Coin.PENNY);
		coinTray.add(Coin.DIME);
		coinTray.add(Coin.QUARTER);
		coinTray.clearBalance();
		coinTray.add(Coin.QUARTER);
		
		assertEquals(25, coinTray.calculateBalance());
	}
}
