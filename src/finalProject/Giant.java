package finalProject;

import java.awt.Color;

import finalProject.Critter.Neighbor;

/*Constructor	public Giant()
getColor	Color.GRAY
toString	"fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, then "fum" for 6 moves, then repeat.
getMove	always infect if an enemy is in front, otherwise hop if possible, otherwise turn right.
*/

public class Giant extends Critter {
	// Attributes
	private int moveCount;
	private String[] stringArray = { "fee", "fie", "foo", "fum" };
	private int stringArrayCounter = 3;

	// Constructors
	public Giant() {
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
		// otherwise turn right if another giant or a wall is in front (changed from original
		// requirements)
		else if (info.getFront() == Neighbor.SAME || info.getFront() == Neighbor.WALL) {
			return Action.RIGHT;
		}
		// otherwise hop if possible
		else {
			return Action.HOP;
		}
	}

	// Color.GRAY
	public Color getColor() {
		return Color.GRAY;
	}

	// "fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, then "fum"
	// for 6 moves, then repeat.
	public String toString() {
		// move array counter up or back to zero
		if (moveCount % 6 == 0 && stringArrayCounter == 3) {
			stringArrayCounter = 0;
		} else if (moveCount % 6 == 0) {
			stringArrayCounter++;
		}
		return stringArray[stringArrayCounter];
	}
}
