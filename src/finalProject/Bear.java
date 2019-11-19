package finalProject;

import java.awt.Color;

/*Constructor	public Bear(boolean polar)
getColor	Color.WHITE for a polar bear (when polar is true), Color.BLACK otherwise (when polar is false)
toString	Should alternate on each different move between a slash character (/) and a backslash character () starting with a slash.
getMove	always infect if an enemy is in front, otherwise hop if possible, otherwise turn left.*/

public class Bear extends Critter {

	// Attributes
	private int moveCount;
	// No logic exists to randomly determine if the bear is a polar bear or not
	private boolean isPolarBear;

	// Constructors
	// public Bear(boolean polar)? <-- no way to send the boolean AFAIK
	public Bear() {
		this.moveCount = 0;
		this.isPolarBear = true;
	}

	// Methods
	public Action getMove(CritterInfo info) {
		// increment moveCount
		moveCount++;

		// always infect if an enemy is in front
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		}

		// or turn left
		// the logic doesn't see to prevent us from hopping, so we'll never turn left as
		// far as I can tell
		// changed to turned if it runs into another bear
		else if (info.getFront() == Neighbor.SAME) {
			return Action.RIGHT;
		}
		
		// turn left if they are facing a wall
		// added by dev, not in original spec
		else if (info.getFront() == Neighbor.WALL) {
			return Action.LEFT;
		}

		// or hop
		else {
			return Action.HOP;
		}
	}

	public Color getColor() {
		// Color options
		if (isPolarBear) {
			return Color.WHITE;
		}
		return Color.BLACK;
	}

	public String toString() {
		if (this.moveCount % 2 == 1) {
			return "/";
		} 
		else {
			return "\\";
		}
	}
}
