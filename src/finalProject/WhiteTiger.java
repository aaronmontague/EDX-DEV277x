package finalProject;

import java.awt.Color;

import finalProject.Critter.Neighbor;

/*Constructor	public WhiteTiger()
getColor	Always Color.WHITE.
toString	"tgr" if it hasn’t infected another Critter yet, “TGR” if it has infected.
getMove	Same as a Tiger. Note: you’ll have to override this method to figure out if it has infected another Critter.
*/

public class WhiteTiger extends Critter {
	// Attributes
	private boolean hasInfectedAnother;

	// Constructors
	public WhiteTiger() {
	}

	// Methods
	public Action getMove(CritterInfo info) {
		// always infect if an enemy is in front
		if (info.getFront() == Neighbor.OTHER) {
			// switch the flag if WhiteTiger performs this action
			if (!hasInfectedAnother) {
				hasInfectedAnother = true;
			}
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

	// Always Color.WHITE.
	public Color getColor() {
		return Color.WHITE;
	}

	// "tgr" if it hasn’t infected another Critter yet, “TGR” if it has infected.
	public String toString() {
		if (hasInfectedAnother) {
			return "TGR";
		} 
		else {
			return "tgr";
		}
	}
}
