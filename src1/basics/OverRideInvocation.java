package basics;

class X {
	void calculate(int a, int b) {
		System.out.println("Class X");
	}

	void calculate1(int a, int b) {
		System.out.println("Class Z");
	}
}

class Y extends X {
	// @Override
	void calculate(int a, int b) {
		System.out.println("Class Y");
	}
}

class Z extends Y {
	// @Override
	void calculate(int a, int b) {
		System.out.println("Class Z");
	}

	// @Override The method calculate2(int, int) of type Z must override or
	// implement a supertype method
	void calculate2(int a, int b) {
		System.out.println("Class Z");
	}
}

public class OverRideInvocation {
	public static void main(String[] args) {
		X x = new Z(); // it all depends on instance-OBJ, not on reference(runtime-polymorphism)
		// x.calculate2(10, 20); compile error
		x.calculate(10, 20);

		Y y = (Y) x;

		y.calculate(50, 100);

		Z z = (Z) y;

		z.calculate(100, 200);
		
	}
}