package evals;

import polymorphism.*;

public class PolyCheck {

	public static void main(String[] args) {
		// Create a new sloth with id
		Sloth reggie = new Sloth(45);
		reggie.eat();
		
		// Cannot access the id directly outside the package
		//reggie.id = 23; 
	}

}
