package com.codecool.vendingmachine;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class VendingMachineTest {
    
	@Test
	public void testVendingMachineExists() {
		VendingMachine vendingMachine = new VendingMachine();
		
		assertThat(vendingMachine).isNotNull();
	}
}
