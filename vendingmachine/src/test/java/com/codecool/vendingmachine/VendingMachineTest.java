package com.codecool.vendingmachine;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;


public class VendingMachineTest {
    
	private VendingMachine vendingMachine;
	
	@BeforeEach
    public void setup() {
        vendingMachine = new VendingMachine();
    }
	
	@Test
	public void testVendingMachineExists() {
		assertThat(vendingMachine).isNotNull();
	}
}
