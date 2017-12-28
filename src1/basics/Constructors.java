package basics;

class SuperConstructor {
	protected SuperConstructor() {
		System.out.println("SuperConstructor");
	}
}

public class Constructors extends SuperConstructor {
	public Constructors() {
		super();
		System.out.println("Noarg-Constructors");
	}
	public Constructors(int i) {
		this();
		System.out.println("Arg-Constructors");
	}
	public static void main(String[] args) {
		new Constructors(10);
	}
}
