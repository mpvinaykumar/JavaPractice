class X {
	int i, j;
}

class Y {
	int i, j;
}

class Z extends X {
	int k;
}

public class InstanceOfDemo {
	public static void main(String args[]) {

		X x = new X();
		Y y = new Y();
		Z z = new Z();

		if (x instanceof X)
			System.out.println("x is an instance of X");

		X obj;
		obj = z; // X reference to z

		Z obj2; 
		//obj2=(Z) x; //can't convert parent class to child, vice versa is possible
		/**
		Exception in thread "main" java.lang.ClassCastException: X cannot be cast to Z
		at InstanceOfDemo.main
		*/
		/*System.out.println(obj2.k);
		System.out.println(obj2.i);*/
		
		if (obj instanceof Z)
			System.out.println("obj is an instance of Z");
		// System.out.println(obj.k); can't access 'k' bcz z it's having parent
		// reference
	}
}