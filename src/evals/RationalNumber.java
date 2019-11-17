package evals;

public class RationalNumber {
	private int num;
	private int den; // den != 0

	/**
	 * Constructs a RationalNumber object.
	 * 
	 * @param n the numerator
	 * @param d the denominator Precondition: d != 0
	 */
	public RationalNumber(int n, int d) {
		num = n;
		den = d;
	}

	/**
	 * Multiplies this RationalNumber by r.
	 * 
	 * @param r a RationalNumber object Precondition: this.den() != 0
	 */
	public void multiply(RationalNumber r) {
		/* missing code */
		num = num * r.num;
		den = den * r.den;
	}

	/**
	 * @return the numerator
	 */
	public int getNum() {
		/* implementation not shown */
		return this.num;
	}

	/**
	 * @return the denominator
	 */
	public int getDen() {
		/* implementation not shown */
		return this.den;
	}

	// Other methods not shown.
}
