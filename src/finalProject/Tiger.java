package finalProject;

import java.awt.Color;
import java.util.Random;

import finalProject.Critter.Neighbor;

/*Constructor	public Tiger()
getColor	Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE) and uses that color for three moves, then randomly picks one of those colors again for the next three moves, then randomly picks another one of those colors for the next three moves, and so on.
toString	"TGR"
getMove	always infect if an enemy is in front, otherwise if a wall is in front or to the right, then turn left, otherwise if a fellow Tiger is in front, then turn right, otherwise hop.*/

public class Tiger extends Critter {
	// Attributes
	private int moveCount;
	private Color currentTigerColor;

	// Constructors
	public Tiger() {
		this.moveCount = 0;
	}

	// Methods
	public Action getMove(CritterInfo info) {
		// increment moveCount
		moveCount++;
		
		// always infect if an enemy is in front
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		}
		// otherwise if a wall is in front or to the right, then turn left
		else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
			return Action.LEFT;
		}
		// otherwise if a fellow Tiger is in front, then turn right
		else if (info.getFront() == Neighbor.SAME) {
			return Action.RIGHT;
		}
		// otherwise hop
		else {
			return Action.HOP;
		}
	}

	public Color getColor() {
		// randomly pick a color(Color.RED, Color.GREEN, Color.BLUE), use it for 3 moves, repeat
		if (this.moveCount % 3 == 0) {
			Random rndTigerColor = new Random();
			// 0-2 on random
			int newTigerColor = rndTigerColor.nextInt(3);
			if (newTigerColor == 0) {
				currentTigerColor = Color.RED;
			}
			else if ( newTigerColor == 1) {
				currentTigerColor = Color.GREEN;
			}
			else {
				currentTigerColor = Color.BLUE;
			}
		}
		return currentTigerColor;
	}

	public String toString() {
		return "TGR";
	}
}
