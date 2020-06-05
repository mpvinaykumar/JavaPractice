package basics;

class BlewIt extends Exception {
	BlewIt() {
	}

	BlewIt(String s) {
		super(s);
	}
}

public class ExceptionProg {
	static void blowUp() throws BlewIt {
		throw new BlewIt();
	}

	public static void main(String[] args) {
		try {
			blowUp();
		} catch (BlewIt b) {
			System.out.println("Caught BlewIt");
		} catch (RuntimeException r) {
			System.out.println("Caught RuntimeException");
		}
	}
}
