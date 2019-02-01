package com.codecool.vendingmachine;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputManager {

	private Scanner reader =  new Scanner(System.in);
	boolean validInput;
	
	int verifyStartingInput() {
		validInput = false;
		Integer number = null;
		while(!validInput) {
			try {
				number = parseStartingInput();
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, try again!");
			}
		}
		return number;
	}
	
	private int parseStartingInput() {
		Integer number = Integer.parseInt(reader.next());
		if(number <= 4 && number >= 1) {
			validInput = true;
		} else {
			System.out.println("Unknown action, try again!");
		}
		return number;
	}

	public int verifySupplierInput() {
		validInput = false;
		Integer number = null;
		while(!validInput) {
			try {
				number = parseSupplierInput();
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, try again!");
			}
			
		}
		return number;
	}
	
	private int parseSupplierInput() {
		Integer number = Integer.parseInt(reader.next());
		if(number == 1 || number == 2) {
			validInput = true;;
		} else {
			System.out.println("Unknown action, try again!");
		}
		return number;
	}

	public int verifyTransactionInput() {
		validInput = false;
		
		Integer number = null;
		while(!validInput) {
			try {
				number = parseTransactionInput();
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, try again!");
			}
			
			
		}
		return number;
	}
	
	private int parseTransactionInput() {
		List<Integer> possibleInputs = Arrays.asList(0, 1, 5, 10, 25);
		Integer number = Integer.parseInt(reader.next());
		if(possibleInputs.contains(number)) {
			validInput = true;
		} else {
			System.out.println("Can't accept this coin, try again!");
		}
		return number;
	}
}
