package com.codecool.vendingmachine;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
	public void testIfVendingMachineServesTheRightProductIfInputIs1() {
		assertEquals(Product.COKE, vendingMachine.getProductByUserInput(1));
	}
	
	@Test
	public void testIfVendingMachineServesTheRightProductIfInputIs2() {
		assertEquals(Product.PEPSI, vendingMachine.getProductByUserInput(2));
	}
	
	@Test
	public void testIfVendingMachineServesTheRightProductIfInputIs4() {
		assertEquals(Product.SODA, vendingMachine.getProductByUserInput(3));
	}
	
	@Test
	public void testIfVendingMachineServesProduct() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
				
		vendingMachine.serveProduct(Product.COKE);
      
		assertEquals("Here is your COKE\n", outContent.toString());
	}
}
