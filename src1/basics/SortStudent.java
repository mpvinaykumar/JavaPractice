package basics;

import java.util.ArrayList;
import java.util.Collections;

class StudentComparable implements Comparable<StudentComparable> {
	int rollno;
	String name;
	int age;

	StudentComparable(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	public int compareTo(StudentComparable st) {
		if (age == st.age)
			return 0;
		else if (age > st.age)
			return 1;
		else
			return -1;
	}
}

public class SortStudent {
	public static void main(String args[]) {
		ArrayList<StudentComparable> al = new ArrayList<StudentComparable>();
		al.add(new StudentComparable(101, "Vijay", 23));
		al.add(new StudentComparable(106, "Ajay", 27));
		al.add(new StudentComparable(105, "Jai", 21));

		Collections.sort(al);
		for (StudentComparable st : al) {
			System.out.println(st.rollno + " " + st.name + " " + st.age);
		}
	}
}