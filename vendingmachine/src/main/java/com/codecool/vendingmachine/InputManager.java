package com.codecool.vendingmachine;

import java.util.List;
import java.util.Scanner;

public class InputManager {

	private Scanner reader =  new Scanner(System.in);
	boolean validInput;
	
	
	int verifyInput(List<Integer> possibleValues) {
		validInput = false;
		Integer number = null;
		while(!validInput) {
			try {
				number = parseInput(possibleValues);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, try again!");
			}
		}
		return number;
	}
	
	private int parseInput(List<Integer> possibleValues) {
		Integer number = Integer.parseInt(reader.next());
		if(possibleValues.contains(number)) {
			validInput = true;
		} else {
			System.out.println("Unknown action, try again!");
		}
		return number;
	}
}
