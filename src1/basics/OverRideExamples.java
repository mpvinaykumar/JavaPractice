package basics;

class MyException extends Exception {
	String s1;

	MyException(String s2) {
		super(s2);
		s1 = s2;
	}

	@Override
	public String toString() {
		return ("Output String = " + s1);
	}
}

class X1 {
	int method(int i) {
		return i *= i;
	}
}

class Y1 extends X1 {
	double method(double d) {
		return d /= d;
	}
}

class Z1 extends Y1 {
	float method(float f) {
		return f += f;
	}
}

class A {
	static void methodOne() {
		System.out.println("AAA");
	}

	void methodTwo() {
		System.out.println("AAA");
	}
}

class B extends A {
	static void methodOne() {
		System.out.println("BBB");
	}

	void methodTwo() throws ArrayIndexOutOfBoundsException{
		int ar[] =new int[10];
		System.out.println(ar[22]);
		System.out.println("BBB");
	}
}

public class OverRideExamples {
	public static void main(String[] args) {
		Z1 z = new Z1();

		System.out.println(z.method(21.12));
		// 21.12 is a double literal, which is why double method(double d) is chosen.
		// For float literals you have to use 21.12f or 21.12F. z.method(21.12f) would
		// invoke float method(float f).

		A a = new B();
		B b = new B();

		b.methodOne(); // invokes static method
		a.methodOne(); // invokes static method, static methods can be overRiden, but gets invoked by
						// Reference not by Object()
		a.methodTwo();// invokes instance method
		try {
			throw new MyException("Custom message");
		} catch (MyException exp) {
			System.out.println(exp);
		}
	}
}
