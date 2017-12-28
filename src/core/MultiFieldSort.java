package core;

/*
http://www.codexpedia.com/java/java-collection-multi-fields-sorting/
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String n, int a) {
		this.name = n;
		this.age = a;
	}

	public String toString() {
		return "Name: " + name + " Age: " + age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Person another) {

		int sComp = this.name.compareTo(another.name);
		// sort by name first and then age
		if (sComp != 0) {
			return sComp;
		} else {
			Integer age1 = this.getAge();
			Integer age2 = another.getAge();
			return age1.compareTo(age2);
		}

	}
}

public class MultiFieldSort {

	public static void main(String args[]) {
		int maxAge = 100;
		int maxNameLength = 10;
		int sampeSize = 100;
		Random random = new Random();

		ArrayList<Person> people = new ArrayList<Person>();

		for (int i = 0; i < sampeSize; i++) {
			Person p = new Person(generateName(), random.nextInt(maxAge));
			people.add(p);
			System.out.println(p.toString());
		}

		Collections.sort(people);
		// Collections.sort(people, new Comparator<Object>() {
		//
		// public int compare(Object o1, Object o2) {
		//
		// String name1 = ((Person) o1).getName();
		// String name2 = ((Person) o2).getName();
		// int sComp = name1.compareTo(name2);
		//
		// if (sComp != 0) {
		// return sComp;
		// } else {
		// Integer age1 = ((Person) o1).getAge();
		// Integer age2 = ((Person) o2).getAge();
		// return age1.compareTo(age2);
		// }
		// }});

		System.out.println("..After sorting..");
		for (Person p : people) {
			System.out.println(p.toString());
		}
	}

	public static String generateName() {
		Random random = new Random();
		String[] names = { "aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii", "jjj", "kkk", "lll", "mmm",
				"nnn" };
		return new String(names[random.nextInt(names.length)]);
	}

	public static String generateString(int maxLength) {
		Random random = new Random();
		int length = random.nextInt(maxLength);
		String characters = "abcdefghijklmnopqrstuvwxyz";
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(random.nextInt(characters.length()));
		}
		return new String(text);
	}
}