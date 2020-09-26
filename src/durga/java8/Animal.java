package durga.java8;


//Demo for Multiple inheritance

interface Moveable {
	default void run() {
		System.out.println("I am running, kid !!");
	}
	default void run3() {
		System.out.println("Common method !!");
	}
}

interface Crawlable {
	default void run2() {
		System.out.println("I am running, daddy !!");
	}
	default void run3() {
		System.out.println("Common method !!");
	}
}

public class Animal implements Moveable, Crawlable {

	@Override
	public void run3() {
		Moveable.super.run3();
	}

	public static void main(String[] args) {
		Animal self = new Animal();
		self.run3();
	}
}