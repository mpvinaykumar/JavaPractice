class Parent {
	public void overRideMethod() {
		System.out.println("Parent overRideMethod");
	};

	public void method() {
		System.out.println("Parent method");
	};
}

class Child1 extends Parent {
	public void overRideMethod() {
		System.out.println("Child1 overRideMethod");
	};

	public void child1Method() {
		System.out.println("child1Method");
	};
}

class Child2 extends Parent {
	public void overRideMethod() {
		System.out.println("Child2 overRideMethod");
	};

	public void child2Method() {
		System.out.println("child2Method");
	};
}

// Parent(X) is a supper class of Child1(Y) and Child2(Z) which are sibblings.

public class RunTimeCastDemo {
	public static void main(String args[]) {
		Parent x = new Parent();
		Child1 y = new Child1();
		Child2 z = new Child2();

		Parent xy = new Child1(); // compiles ok (up the hierarchy)
		Parent xz = new Child2(); // compiles ok (up the hierarchy)
		// Child1 yz = new Child2(); incompatible type (sibblings)

		// Child1 y1 = new Parent(); Parent is not a Child1
		// Child2 z1 = new Parent(); Parent is not a Child2

		Parent x1 = y; // compiles ok (y is subclass of Parent)
		Parent x2 = z; // compiles ok (z is subclass of Parent)

		//Child1 y1 = (Child1) x; // compiles ok but produces runtime error, java.lang.ClassCastException: Parent
								// cannot be cast to Child1
		//Child2 z1 = (Child2) x; // compiles ok but produces runtime error
		Child1 y2 = (Child1) x1; // compiles and runs ok (x1 is type Child1)
		Child2 z2 = (Child2) x2; // compiles and runs ok (x2 is type Child2)
		// Child1 y3 = (Child1) z; inconvertible types (sibblings)
		// Child2 z3 = (Child2) y; inconvertible types (sibblings)

		Object o = z;
		// Object o1 = (Child1)o; // compiles ok but produces runtime error(Child2
		// cannot be cast to Child1)

		//parent obj assigning to child ref, compile ok, but runtime error will come
		Child1 ch1 = (Child1) new Parent(); // runtime error (Parent cannot be cast to Child1)
		ch1.overRideMethod();
		ch1.child1Method();
		
		//check other example OverRideInvocation example
	}
}