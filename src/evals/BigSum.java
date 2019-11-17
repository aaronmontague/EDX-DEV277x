package evals;

public class BigSum extends Sum {
	public int doCalc() {
		int x = super.doCalc();
		return x + doAnotherCalc();
	}

	public int doAnotherCalc() {
		return 100;
	}
}
