package co.grandcircus;

import java.util.Random;
import java.util.Scanner;

public class RollDiceSimulator {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String response = "";
		System.out.println("How many sides should each die have?");
		int sides = scnr.nextInt();
		do {
			int x = generateRandomDieRoll(sides);
			int y = generateRandomDieRoll(sides);

			if (checkSnakeEyes(x, y)) {
				System.out.println("Snake Eyes!");
				System.out.println("Crapped out!");
				System.out.println("You rolled: " + "\n" + x + "\n" + y);
			} else if (checkCraps(x, y)) {
				System.out.println("Crapped out!");
				System.out.println("You rolled: " + "\n" + x + "\n" + y);
			} else if (checkBoxCars(x, y)) {
				System.out.println("Box Cars!");
				System.out.println("You rolled: " + "\n" + x + "\n" + y);
			} else {
				System.out.println("You rolled: " + "\n" + x + "\n" + y);
			}
			System.out.println("");
			System.out.println("Roll again? (y/n)");
			response = scnr.next();
		} while (response.equalsIgnoreCase("y"));
		scnr.close();
	}

	public static int generateRandomDieRoll(int sides) {
		Random randGen = new Random();
		return randGen.nextInt(sides) + 1;
	}

	public static boolean checkCraps(int x, int y) {
		boolean craps = false;
		int sum = x + y;
		if (sum == 2 || sum == 3 || sum == 12) {
			craps = true;
		}
		return craps;
	}

	public static boolean checkSnakeEyes(int x, int y) {
		boolean snakeEyes = false;
		if (x == 1 && y == 1) {
			snakeEyes = true;
		}
		return snakeEyes;
	}

	public static boolean checkBoxCars(int x, int y) {
		boolean boxCars = false;
		if (x == 6 && y == 6) {
			boxCars = true;
		}
		return boxCars;
	}
}
