package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class StudentComparator {
	int id;
	String name;
	int age;

	public StudentComparator(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
}

class AgeComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		StudentComparator s1 = (StudentComparator) o1;
		StudentComparator s2 = (StudentComparator) o2;

		if (s1.age == s2.age)
			return 0;
		else if (s1.age > s2.age)
			return 1;
		else
			return -1;
	}
}

class NameComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		StudentComparator s1 = (StudentComparator) o1;
		StudentComparator s2 = (StudentComparator) o2;

		return s1.name.compareTo(s2.name);
	}
}

public class ComparatorExample {
	public static void main(String args[]) {

		ArrayList<StudentComparator> al = new ArrayList();
		al.add(new StudentComparator(101, "Vijay", 23));
		al.add(new StudentComparator(106, "Ajay", 27));
		al.add(new StudentComparator(105, "Jai", 21));

		System.out.println("Sorting by Name...");

		Collections.sort(al, new NameComparator());
		Iterator itr = al.iterator();
		while (itr.hasNext()) {
			StudentComparator st = (StudentComparator) itr.next();
			System.out.println(st.id + " " + st.name + " " + st.age);
		}

		System.out.println("\nsorting by age...");

		Collections.sort(al, new AgeComparator());
		Iterator itr2 = al.iterator();
		while (itr2.hasNext()) {
			StudentComparator st = (StudentComparator) itr2.next();
			System.out.println(st.id + " " + st.name + " " + st.age);
		}

	}
}