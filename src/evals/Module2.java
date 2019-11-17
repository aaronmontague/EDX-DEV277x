package evals;

public class Module2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RationalNumber twoThirds = new RationalNumber(2, 3);
		RationalNumber twoThirds2 = new RationalNumber(2, 3);
		
		System.out.println(twoThirds.getNum() + "/" + twoThirds.getDen());
		// Multiply
		twoThirds.multiply(twoThirds2);
		System.out.println(twoThirds.getNum() + "/" + twoThirds.getDen());
	}
}
	