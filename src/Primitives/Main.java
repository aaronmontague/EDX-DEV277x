package Primitives;

//import arrayList.VariousArrayList;
import games.BattleShip;
import models.GameState;

public class Main {

	public static void main(String[] args) {
		//VariousArrayList.makeArrayList();
		//ArrayCopy.copyThis();
		//TwoDArray.make2DArray(4, 5);
		
		// Game variables
		GameState currentBattle = new GameState(null, 5, 5);
		int turn = 1;
		int boardSizeVertical = 10;
		int boardSizeHorizontal = 10;
		
		String[][] oceanMap = new String[boardSizeVertical][boardSizeHorizontal];
		
		// Display Map
		BattleShip.displayMap(oceanMap);
		
		// Place human ships
		BattleShip.placeHumanShips(oceanMap, currentBattle.getHumanShips());
		
		// Display Map with Human Ships
		BattleShip.displayMap(oceanMap);
		
		// Place computer ships
		BattleShip.placeComputerShips(oceanMap, currentBattle.getComputerShips());
		System.out.println("The computer ships are placed, and hidden, begin the battle!");
		
		// Battle for dominance of the oceans!
		while (currentBattle.getWinner() == null) {
			// Display game information
			System.out.println("Turn: " + turn);
	
			// Score
			// Current Map
			BattleShip.displayMap(oceanMap);
			
			// Player Turn
			// Computer Turn
			currentBattle.setWinner(BattleShip.turn(oceanMap, currentBattle));
			// Continue or Declare Victory
			turn++;
		}
		
		// Declare Winner
		if (currentBattle.getWinner() == "Computer") {
			System.out.println("The End is Nigh, The Machines are Victorious");
		}
		else {
			System.out.println("Game Over, Human Insight Clamins the day");
		}
		System.out.println("Thank You For Playing :)");
	}
}
