package core;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
	int id;
	String name;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

public class Comptr {

	public static void main(String[] args) {
		Employee emp1 = new Employee(1, "emp1");
		Employee emp2 = new Employee(2, "emp3");
		Employee emp3 = new Employee(3, "emp2");

		List<Employee> empList = new ArrayList<Employee>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);

		for (Employee emp : empList) {
			System.out.println(emp.getName());
		}

		Collections.sort(empList, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}

		});

		for (Employee emp : empList) {
			System.out.println(emp.getName());
		}
	}
}
