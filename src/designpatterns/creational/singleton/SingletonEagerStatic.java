package com.patterns.creational.singleton;

public class SingletonEagerStatic {
	private static SingletonEagerStatic instance = null;

	static{
		try {
			instance = new SingletonEagerStatic();
		}catch(Exception ex){
			System.out.println("Exception occured in creation Singleton");
		}
	}
	
	private SingletonEagerStatic() {
	}

	public static SingletonEagerStatic getInstance() {
		return instance;
	}
}
