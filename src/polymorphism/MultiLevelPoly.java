package polymorphism;

public class MultiLevelPoly {
	public static void main(String[] args) {
		Animal animal1 = new Platypus();
		System.out.println("animal1 = Platypus");
		animal1.eat();
		
		Mammal mammal1 = new Sloth();
		System.out.println("mammal1 = Sloth");
		mammal1.eat();
		
		Sloth chewy = new Sloth(12, "Chewy");
		System.out.println("Chewy Says:");
		chewy.eat();
		
		// Id change
		System.out.println(chewy.id);
		chewy.id = 14;
		System.out.println(chewy.id);
		
		// Laying Eggs
		chewy.displayEggLaying();
		Platypus gerty = new Platypus(123, "Gerty");
		gerty.displayEggLaying();
		// Default False though
		Platypus srianka = new Platypus();
		srianka.displayEggLaying();
	}
}