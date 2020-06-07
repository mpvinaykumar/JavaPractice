package com.patterns.creational.singleton;

public class SingletonInnerStatic {
		
	private SingletonInnerStatic() {
	}

	private static class InnerClass {
		private static final SingletonInnerStatic instance =  new SingletonInnerStatic() ;
	}

	public static SingletonInnerStatic getInstance() {
		return InnerClass.instance;
	}
}
