package basics;

class SuperClass {

	void superClassMethod(Number n) {
		System.out.println("From Super Class");
	}
}

class SubClass extends SuperClass {
	// void superClassMethod(double d) typePromote and invokes this method not
	// Number
	void superClassMethod(Double d) {
		System.out.println("From Sub Class");
	}
}

class OverLoadAmbiguity {
	void m(float a, int b, byte c) {
	}

	void m(byte a, byte b, double c) {
	}

	void m(byte a, int b, byte c) {
	}

	void m(double a, int b, int c) {
		System.out.println("second");
	}

	void m(float a, int b, double c) {
		System.out.println("first");
	}
}

public class OverLoadInvocation {
	public static void main(String[] args) {
		SubClass sub = new SubClass();

		sub.superClassMethod(123321); // From Super class
		sub.superClassMethod(123321d); // From Sub class

		OverLoadAmbiguity ambiguity = new OverLoadAmbiguity();
		byte b = 0;

		// ambiguity.m(b, b, b); //The method m(float, int, byte) is ambiguous for the
		// type OverLoadAmbiguity
		// ambiguity.m(23, 12, 1); //ambiguous
	}
}
