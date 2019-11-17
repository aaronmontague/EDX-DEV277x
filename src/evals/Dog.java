package evals;

public class Dog extends Pet {
	// Attributes
	private String b;

	// Constructors
	public Dog() {}

	
    public Dog (int weight, String color, String breed) {
       super(weight, color);
       this.b = breed;
    }

	// Methods
}
