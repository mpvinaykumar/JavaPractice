package youtube.durga.java8;

interface Interf {
	public void m1();
}

public class SimpleLambda {

	public static void main(String[] args) {

		/** Ex-1 **/
		Interf in = () -> System.out.println("Hello...");
		in.m1();

		/** Ex-2 **/
		Runnable r = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Child Thread-1");
			}
		};
		Thread t = new Thread(r);
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("Main Thread-11");
		}
	}
}

// D:\Learn\eclipseWS\JavaPractice\bin\youtube\durga\java8

/*
 * @FunctionalInterface public interface A { public void m1(); //Valid }
 * 
 * @FunctionalInterface public interface B extends A { public void m1(); //Valid
 * }
 * 
 * @FunctionalInterface public interface B extends A { public void m2();
 * //InValid, Bcz interface-B contains 2 abstract-methods. } //Normal interface
 * public interface B extends A { public void m1(); //Valid public void m2();
 * //InValid }
 */