package games;

import java.util.Scanner;

import models.GameState;

import java.util.Random;

public class BattleShip {
	public static String turn(String[][] oMap, GameState thisGame) {
		// Human Turn
		// Get Coords of Attack
		System.out.println("Enter Attack Coords (X,Y):");
		int thisHumanX;
		System.out.println("X(horizontal): (Input 0-9)");
		thisHumanX = validateIntZeroToNine();

		int thisHumanY;
		System.out.println("Y(vertical): (Input 0-9)");
		thisHumanY = validateIntZeroToNine();

		// Check to See if a ship is there
		String thisHumanAttack = getOceanSquareValue(thisHumanY, thisHumanX, oMap);
		// System.out.println("Human Attack: " + thisHumanAttack);

		// Hit or Miss | @ = human, C = Computer, null = empty ocean, X = sunk human
		// ship, ! = sunk computer ship, - = miss

		// Handle the null return before the switch
		if (thisHumanAttack == null) {
			thisHumanAttack = "null";
		}
		switch (thisHumanAttack) {
		case "@":
			oMap[thisHumanY][thisHumanX] = "X";
			thisGame.sinkHumanShip();
			System.out.println("You sunk your own ship");
			break;
		case "C":
			oMap[thisHumanY][thisHumanX] = "!";
			thisGame.sinkComputerShip();
			System.out.println("BOOM! You sunk the computer ship at: " + thisHumanX + "," + thisHumanY);
			break;
		default:
			oMap[thisHumanY][thisHumanX] = "-";
			System.out.println("Missed by an ocean");
			break;
		}

		// Check to see if the game should continue
		displayEachTeamsRemainingShips(thisGame);
		if (thisGame.getHumanShips() == 0) {
			thisGame.computerWins();
			return "Computer";
		}
		if (thisGame.getComputerShips() == 0) {
			thisGame.humanWins();
			return "Human";
		}

		// Computer Turn
		// Only occurs if the human didn't win, or lose, the game on the top of the turn

		// Get Coords of Attack
		int thisComputerX = getComputerIntZeroToNine();
		int thisComputerY = getComputerIntZeroToNine();

		// Check to See if a ship is there
		String thisComputerAttack = getOceanSquareValue(thisComputerY, thisComputerX, oMap);
		// System.out.println("Computer Attack: " + thisComputerAttack);

		// Hit or Miss | @ = human, C = Computer, null = empty ocean, X = sunk human
		// ship, ! = sunk computer ship, - = miss

		// Handle the null return before the switch
		if (thisComputerAttack == null) {
			thisComputerAttack = "null";
		}
		switch (thisComputerAttack) {
		case "@":
			oMap[thisComputerY][thisComputerX] = "X";
			thisGame.sinkHumanShip();
			System.out.println("The machines sunk one of your ships");
			break;
		case "C":
			oMap[thisComputerY][thisComputerX] = "!";
			thisGame.sinkComputerShip();
			System.out.println("Computer AI failed, they sunk their own ship");
			break;
		default:
			// Do not display computer misses to human
			System.out.println("The computer did not hit anything");
			break;
		}

		// End Computer Turn

		// Check to see if the game should continue
		displayEachTeamsRemainingShips(thisGame);
		if (thisGame.getHumanShips() == 0) {
			thisGame.computerWins();
			return "Computer";
		}
		if (thisGame.getComputerShips() == 0) {
			thisGame.humanWins();
			return "Human";
		}

		// Keep the game going
		return null;
	}

	public static void placeHumanShips(String[][] oMap, int numberHumanShips) {
		// Get coords for ships, add them to the map
		int placedHumanShips = 1;

		System.out.println("Please Input Coords for each ship");

		// Loop through the ships
		while (placedHumanShips <= numberHumanShips) {
			// Validate X
			int thisX;
			System.out.println("Ship #" + (placedHumanShips) + " X(horizontal): (Input 0-9)");
			thisX = validateIntZeroToNine();

			// Validate Y
			int thisY;
			System.out.println("Ship #" + (placedHumanShips) + " Y(vertical): (Input 0-9)");
			thisY = validateIntZeroToNine();

			// Place ship on grid, check to make sure no ship is there
			if (getOceanSquareValue(thisY, thisX, oMap) == null) {
				oMap[thisY][thisX] = "@";
				placedHumanShips++;
			} else {
				System.out.println("That location already has a ship, please select another");
			}
		}
	}

	public static void placeComputerShips(String[][] oMap, int numberComputerShips) {
		// Place 5 ships randomly
		// Can't be on the same spot as a players ship
		int placedComputeShips = 1;

		while (placedComputeShips <= numberComputerShips) {
			int thisY = getComputerIntZeroToNine();
			int thisX = getComputerIntZeroToNine();

			// Make sure the ocean square is empty
			if (getOceanSquareValue(thisY, thisX, oMap) == null) {
				oMap[thisY][thisX] = "C";
				placedComputeShips++;
			}
		}
	}

	public static String getOceanSquareValue(int vertical, int horizontal, String[][] oceanMap) {
		return oceanMap[vertical][horizontal];
	}

	public static int getComputerIntZeroToNine() {
		Random rndComp = new Random();
		return rndComp.nextInt(9);
	}

	public static void displayEachTeamsRemainingShips(GameState thisGame) {
		System.out.println("Human Ships: " + thisGame.getHumanShips());
		System.out.println("Comp Ships: " + thisGame.getComputerShips());
	}

	public static int validateIntZeroToNine() {
		// Need to make sure the input is an int inclusively between 0 and 9
		int tempInt = -1;
		Scanner validIntScanner = new Scanner(System.in);

		while (tempInt < 0 || tempInt > 9) {
			System.out.println("Please Enter a number 0-9");
			while (!validIntScanner.hasNextInt()) {
				System.out.println("That's not a number between, and including, 0-9!");
				validIntScanner.next();
			}
			tempInt = validIntScanner.nextInt();
		}
		return tempInt;
	}

	public static void displayMap(String[][] oMap) {
		// Header
		System.out.println("   0123456789");

		// Display Grid
		// Get vertical size
		int verticalSizeOfMap = oMap.length;

		// Each row will need to be calculated on the fly
		for (int i = 0; i < verticalSizeOfMap; i++) {
			System.out.format("%d |", i);

			for (int j = 0; j < oMap[i].length; j++) {
				// Null value should print out a space " "
				// Hide Computer Ships "C" until they are sunk
				if (oMap[i][j] == null || oMap[i][j] == "C") {
					System.out.print(" ");
				} else {
					System.out.print(oMap[i][j]);
				}
			}

			System.out.format("| %d%n", i);
		}

		// Footer
		System.out.println("   0123456789");
	}
}
