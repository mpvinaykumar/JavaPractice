package core;

//Java program to demonstrate working of isInstance()
//method
public class InstanceTest {
	// This method tells us whether the object is an
	// instance of class whose name is passed as a
	// string 'c'.
	public static boolean fun(Object obj, String c) throws ClassNotFoundException {
		return Class.forName(c).isInstance(obj);
	}

	// Driver code that calls fun()
	public static void main(String[] args) throws ClassNotFoundException {
		Integer i = new Integer(5);

		// print true as i is instance of class
		// Integer
		boolean b = fun(i, "java.lang.Integer");

		// print false as i is not instance of class
		// String
		boolean b1 = fun(i, "java.lang.String");

		/*
		 * print true as i is also instance of class Number as Integer class extends
		 * Number class
		 */
		boolean b2 = fun(i, "java.lang.Number");

		System.out.println(b);
		System.out.println(b1);
		System.out.println(b2);

	}
}
