package core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapIterations {
	public static void main(String[] args) {
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();

		/* Adding elements to HashMap */
		hmap.put(12, "Chaitanya");
		hmap.put(2, "Rahul");
		hmap.put(7, "Singh");
		hmap.put(49, "Ajeet");
		hmap.put(3, "Anuj");

		Set<Entry<Integer, String>> e = hmap.entrySet();
		Iterator<Entry<Integer, String>> itr = e.iterator();

		System.out.println("iterations while...");
		while (itr.hasNext()) {
			Entry<Integer, String> mm = itr.next();
			System.out.println(mm.getValue());
		}

		System.out.println("iterations for...");
		for (Iterator iterator = e.iterator(); iterator.hasNext();) {
			Entry<Integer, String> entry = (Entry<Integer, String>) iterator.next();
			System.out.println(entry.getValue());

		}

		System.out.println("iterations for...");
		for (Entry<Integer, String> entry : e) {
			System.out.println(entry.getKey());
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
}
