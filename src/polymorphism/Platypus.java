package polymorphism;

public class Platypus extends Mammal {
	// Attributes

	// Constructors
	public Platypus() {
	}

	public Platypus(int playpusId) {
		this.id = playpusId;
		this.laysEggs = true;
	}

	public Platypus(int playpusId, String platypusName) {
		this.id = playpusId;
		this.name = platypusName;
		this.laysEggs = true;
	}

	// Methods
}
