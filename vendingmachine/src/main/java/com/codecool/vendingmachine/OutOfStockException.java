package com.codecool.vendingmachine;

public class OutOfStockException  extends RuntimeException {
	public OutOfStockException() {
        super("The chosen product is out of stock");
    }
}
