package designpatterns.creational.singleton;

public class SingletonThreadSafeDL {
	private static SingletonThreadSafeDL instance = null;

	private SingletonThreadSafeDL() {
	}

	public static  SingletonThreadSafeDL getInstance() {
		if (instance == null) {
			synchronized (SingletonThreadSafeDL.class){
				if (instance == null){
					instance = new SingletonThreadSafeDL();
				}
			}
		}
		return instance;
	}
}
