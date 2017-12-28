package collections;

//Java program to illustrate 
//WeakHashmap 
import java.util.WeakHashMap;

public class WeakHashMapDemo {
	public static void main(String args[]) throws Exception {
		WeakHashMap m = new WeakHashMap();
		Demo d = new Demo();

		// puts an entry into WeakHashMap
		m.put(d, " Hi ");
		System.out.println(m);

		d = null;

		// garbage collector is called
		System.gc();

		// thread sleeps for 4 sec
		Thread.sleep(4000);

		System.out.println(m);
	}
}

class Demo {
	public String toString() {
		return "demo";
	}

	// finalize method
	public void finalize() {
		System.out.println("finalize method is called");
	}
}
