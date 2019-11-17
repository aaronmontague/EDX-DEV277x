package models;

public class GameState {
	// Attributes
	private String winner;
	private int humanShips;
	private int computerShips;
	
	// Constructors
	public GameState() {}
	public GameState(String win, int hs, int cs) {
		this.setWinner(win);
		this.setHumanShips(hs);
		this.setComputerShips(cs);
	}
	
	// Methods
	// Victories
	public void humanWins() {
		System.out.println("The Human Wins");
	}
	public void computerWins() {
		System.out.println("Vicotry for the Machines!");
	}
	
	// Winner
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	// Human Ships
	public int getHumanShips() {
		return humanShips;
	}
	public void setHumanShips(int humanShips) {
		this.humanShips = humanShips;
	}
	public void sinkHumanShip() {
		this.humanShips--;
	}
	
	// Computer Ships
	public int getComputerShips() {
		return computerShips;
	}
	public void setComputerShips(int computerShips) {
		this.computerShips = computerShips;
	}
	public void sinkComputerShip() {
		this.computerShips--;
	}
}
