package polymorphism;

public abstract class Animal {
	// Attributes
	int id;
	String name;
	boolean laysEggs;

	// Constructors
	public Animal() {
	}

	public Animal(int animalId, String animalName) {
		this.id = animalId;
		this.name = animalName;
	}

	// Methods
	abstract void eat();

	public void displayEggLaying() {
		System.out.format("It is %s that %s lays eggs.%n", this.laysEggs, this.name);
	}
}