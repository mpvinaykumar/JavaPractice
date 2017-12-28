package com.java8.features;

class Human {
	public void walk() // Dynamic
	{
		System.out.println("Human walks");
	}

	 void walk1() // Static
	{
		System.out.println("Human walks");
	}

}

public class Boy extends Human {
	public void walk() {
		System.out.println("Boy walks");
	}

	public static void main(String args[]) {
		// Reference is of parent class
		Boy stat = new Boy(); // Static
		Human dyn = new Boy(); // Dynamic
		stat.walk1();
		dyn.walk();
	}
}
