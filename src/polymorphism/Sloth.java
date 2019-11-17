package polymorphism;

public class Sloth extends Mammal {

	// Attributes

	// Constructors
	public Sloth() {
	}

	public Sloth(int slothId) {
		this.id = slothId;
		this.laysEggs = false;
	}

	public Sloth(int slothId, String slothName) {
		this.id = slothId;
		this.name = slothName;
		this.laysEggs = false;
	}

	// Methods
	public void eat() {
		super.eat();
		System.out.println("I eat children's dreams");
	}

}
