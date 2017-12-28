abstract class Animal {
	public abstract void move();
}

class Shark extends Animal {
	public void move() {
		swim();
	}

	public void swim() {
	}

	public void bite() {
	}
}

class Dog extends Animal {
	public void move() {
		run();
	}

	public void run() {
	}

	public void bark() {
	}
}

public class InheritanceOverride {
	public static void main(String[] args) {
		somethingSpecific(new Shark());
		somethingSpecific(new Dog());
	}
	static void somethingSpecific(Animal animal) {
		// Here you don't know and may don't care which animal enters
		animal.move(); // You can call parent methods but you can't call bark or
						// bite.
		if (animal instanceof Shark) {
			Shark shark = (Shark) animal;
			shark.bite(); // Now you can call bite!
		}
		// doSomethingSharky(animal); // You cannot call this method.
	}
}
