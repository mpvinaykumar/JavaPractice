package core;

class GenericClass<T> {
	T t;

	public GenericClass(T t) {
		this.t = t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public static <E> void printArray(E[] inputArray) {
		// Display array elements
		for (E element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}
}

class A {
	int i;

	public A(int i) {
		this.i = i;
	}
}

public class GenericsInJava {

	// Erasure of method print(Set<Integer>) is the same as another method in type
	// GenericsInJava
	/*
	 * public void print(Set<String> strSet) { }
	 * 
	 * public void print(Set<Integer> intSet) { }
	 */

	public static void main(String[] args) {
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

		GenericClass<A> gen1 = new GenericClass<A>(new A(10)); // Passing A-type as type parameter
		GenericClass<A> gen2 = new GenericClass<A>(new A(20)); // Passing A-type as type parameter

		System.out.println(gen1.getT().i); // Output : 10
		System.out.println(gen2.getT().i); // Output : 20

		GenericClass<String> gen3 = new GenericClass<String>("Value Of t T(string)");
		GenericClass<Integer> gen4 = new GenericClass<Integer>(new Integer(20));

		System.out.println(gen3.getT());

		// gen3 = gen4; //Error : Type mismatch
		// gen4 = gen3; //Error : Type mismatch

		// GenericClass<int> gen1 = new GenericClass<int>(123); //Error, can't use
		// primitive type

		System.out.println("\nArray characterArray contains:");
		GenericClass.printArray(charArray); // pass a Character array

		// Type mismatch: cannot convert from ArrayList<Object> to List<String>
		/*
		 * List<String> objList = new ArrayList<Object>();
		 * 
		 * List<Object> objList2 = new ArrayList<String>();
		 */

	}
}