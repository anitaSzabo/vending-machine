package com.codecool.vendingmachine;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;


public class VendingMachineTest {
    
	private VendingMachine vendingMachine;
	private CoinTray coinTray;
	private ProductInventory inventory;
	
	@BeforeEach
    public void setup() {
        coinTray = mock(CoinTray.class);
        inventory = mock(ProductInventory.class);
        vendingMachine = new VendingMachine(coinTray, inventory);
    }
	
	@Test
	public void testVendingMachineExists() {
		assertThat(vendingMachine).isNotNull();
	}
	
	@Test
	public void testIfVendingMachineReturnsTotalConsumption() {
		Map<Product, Integer> productsTotalSold = new HashMap<>();
		productsTotalSold.put(Product.COKE, 0);
		productsTotalSold.put(Product.PEPSI, 0);
		productsTotalSold.put(Product.SODA, 0);
		
		when(inventory.getTotalSold()).thenReturn(productsTotalSold);
		
		assertEquals(productsTotalSold, vendingMachine.getConsumptionReport());
		
		
	}
}
