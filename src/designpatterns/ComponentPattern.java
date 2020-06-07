package designpatterns;

//http://www.thejavageek.com/2016/10/20/composite-design-pattern-implementation/
import java.util.ArrayList;
import java.util.List;

interface ComponentInterf {
	public void printDetails();
}

class Part implements ComponentInterf {
	private String name;

	public Part(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void printDetails() {
		System.out.println(this.getName());
	}

}

class Car implements ComponentInterf {

	private List<ComponentInterf> parts = new ArrayList<ComponentInterf>();
	private String name;

	public Car(String name) {
		this.name = name;
	}

	@Override
	public void printDetails() {
		System.out.println(this.name);
		for (ComponentInterf p : parts) {
			System.out.println("    " + ((Part) p).getName());
		}
	}

	public void addPart(ComponentInterf part) {
		this.parts.add(part);
	}

}

public class ComponentPattern {
	public static void main(String[] args) {

		// separately creating parts which are leaf nodes
		Part engine = new Part("Engine");
		Part wheels = new Part("Wheels");
		Part doors = new Part("doors");

		// Creating a composite object i.e. Car which can have multiple
		// accessories i.e. it is composed of multiples objects
		Car car = new Car("Honda");
		car.addPart(engine);
		car.addPart(wheels);

		/// we are performing operation on leaf.
		engine.printDetails();

		// performing operation on composite object
		car.printDetails();

	}
}