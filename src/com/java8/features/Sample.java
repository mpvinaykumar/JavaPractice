package com.java8.features;

import java.util.function.Predicate;
import java.util.function.Supplier;

class Sample {
	int classVar = 31;
	static int statClassVar = 51;
	
	
	void fn() {
		int myVar = 42;
		Supplier<String> lambdaFun = () -> {
		//myVar++;
		classVar++;
		statClassVar++;
		return classVar +":"+ statClassVar;
		};
		System.out.printf("In Lambda %s \n", lambdaFun.get());
		
		Predicate<String> startsWithA = (text) -> text.startsWith("A");
		Predicate<String> endsWithX   = (text) -> text.endsWith("x");

		Predicate<String> startsWithAAndEndsWithX =
		        (text) -> startsWithA.test(text) && endsWithX.test(text);


Predicate<String> composed = startsWithA.and(endsWithX);

String input = "A hardworking person must relax";
boolean result = composed.test(input);
System.out.println(result);
	}

	public static void main(String[] args) {
		MyJavaCounter v = new MyJavaCounter(42);
		System.out.println(v.get()); // returns 42
		System.out.println(v.increment()); // returns 42
		System.out.println(v.get()); // returns 43
		
		Sample samp = new Sample();
		System.out.println(statClassVar +":"+ samp.classVar);
		samp.fn();
	}
}

class MyJavaCounter {
	private int value;

	public MyJavaCounter(int initValue) {
		this.value = initValue;
	}

	public int increment() {
		return value++;
	}

	public int get() {
		return value;
	}
}