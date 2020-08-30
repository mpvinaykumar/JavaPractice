package com.java8.features;

interface Foo {
	default String defMethod() { 
		return "defMethod from Foo..";
	}
}

interface Goo extends Foo {
	default String defMethod() { 
		return "defMethod from Goo..";
	}
}

class FooClass {
	String normMethod() { 
		return "normMethod from FooClass..";
	}
}

class GooClass extends FooClass {
	 String normMethod() { 
		return "normMethod from GooClass..";
	}
}

public class Multi_Inheritance extends GooClass implements Goo {
	public static void main(String args[]) {
		Multi_Inheritance multiInher = new Multi_Inheritance();
		System.out.println(multiInher.defMethod());
		System.out.println(multiInher.normMethod());
	}
}
