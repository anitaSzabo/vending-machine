package com.codecool.vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LoggerTest {
	
	private ByteArrayOutputStream outContent;
	private Logger logger;
	
	@BeforeEach
	void setup() {
		logger =  new Logger();
		outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
	}
	
	@Test
	public void testLoggerExists() {
		assertThat(logger).isNotNull();
	}
	
	@Test
	public void testIfLoggerLogsMessage() {
		logger.log("Hello World!");
      
		assertEquals("Hello World!\n", outContent.toString());
	}
	
	@Test
	public void testIfLoggerLogsSupplierMenu() {
		logger.logSupplierMenu();
		
		assertEquals("1 - Resupply machine\n2 - Consumption report\n", outContent.toString());
	}
	
	@Test
	public void testIfLoggerLogsTransaction() {
		logger.logTransaction(30, 25);
		
		assertEquals("Total price: 30\nRemaining price: 5\nPlease insert coins! \nYou can choose between 1, 5, 10 and 25.\nPress 0 for cancelling.\n", 
				outContent.toString());
	}	
	
}
