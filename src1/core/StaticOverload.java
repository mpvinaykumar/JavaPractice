package core;

public class StaticOverload {
	/*
	 * Calling the disp() method, Cannot make a static reference to the non-static
	 * method disp()
	 */
	/*public void disp() {
		System.out.println("Non static disp() method called");
	}*/

	public static void disp() {
		System.out.println("static disp() method called121");
	}

	public static void disp(String name) {
		System.out.println("static disp() method with parameter called : " + name);
	}

	public static void main(String args[]) {

		StaticOverload.disp();
		StaticOverload.disp("123");

	}
}
