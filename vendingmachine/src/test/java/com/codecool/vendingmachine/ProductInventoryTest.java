package com.codecool.vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductInventoryTest {
	
	private ProductInventory productInventory;
	
	@BeforeEach
	public void setup() {
		productInventory = new ProductInventory();
	}
	
	@Test
	public void testProductInventoryExists() {
		assertThat(productInventory).isNotNull();
	}
	
	@Test
	public void testIfProductInventoryResetsCoke() {
		productInventory.resupply();
		
		assertEquals(50, productInventory.getInventory().get(Product.COKE));
	}
	
	@Test
	public void testIfProductInventoryResetsPepsi() {
		productInventory.resupply();
		
		assertEquals(50, productInventory.getInventory().get(Product.PEPSI));
	}
	
	@Test
	public void testIfProductInventoryResetsSoda() {
		productInventory.resupply();
		
		assertEquals(50, productInventory.getInventory().get(Product.SODA));
	}
	
	@Test
	public void testIfProductInventoryDecreasesAfterServingProduct() {
		productInventory.resupply();
		productInventory.serve(Product.COKE);
		
		assertEquals(49, productInventory.getInventory().get(Product.COKE));
	}
	
	@Test
	public void testIfProductInventoryThrowsErrorWhenInventoryIs0() {
		assertThrows(OutOfStockException.class, ()-> {
			productInventory.serve(Product.SODA);
        });
	}
	
	@Test
	public void testIfProductIsAddedToTotalSoldAfterServing() {
		productInventory.resupply();
		productInventory.serve(Product.SODA);
		
		assertEquals(1, productInventory.getTotalSold().get(Product.SODA));
		
	}

	
}
