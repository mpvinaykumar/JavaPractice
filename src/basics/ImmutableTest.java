package basics;

import java.util.Date;
import java.util.HashMap;

//An immutable class
final class ImmutableStudent {
	final String name;
	final int regNo;

	private final HashMap<String, String> testMap;
	private final Date fDateOfDiscovery;

	public ImmutableStudent(String name, int regNo, HashMap<String, String> hm, Date aDateOfDiscovery) {
		this.name = name;
		this.regNo = regNo;
		this.testMap = hm;
		fDateOfDiscovery = new Date(aDateOfDiscovery.getTime());
	}

	public String getName() {
		return name;
	}

	public int getRegNo() {
		return regNo;
	}

	public HashMap<String, String> getTestMap() {
		// return testMap;
		return (HashMap<String, String>) testMap.clone();
	}

	/**
	 * Returns a mutable object - likely bad style.
	 *
	 * The caller gets a direct reference to the internal field. This is usually
	 * dangerous, since the Date object state can be changed both by this class and
	 * its caller. That is, this class is no longer in complete control of fDate.
	 */

	// public Date getDateOfDiscovery() { return fDateOfDiscovery; }

	/**
	 * Returns a mutable object - good style.
	 * 
	 * Returns a defensive copy of the field. The caller of this method can do
	 * anything they want with the returned Date object, without affecting the
	 * internals of this class in any way. Why? Because they do not have a reference
	 * to fDate. Rather, they are playing with a second Date that initially has the
	 * same data as fDate.
	 */
	public Date getDateOfDiscovery() {
		return new Date(fDateOfDiscovery.getTime());
	}
}

// Driver class
public class ImmutableTest {
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("1", "first");
		hm.put("2", "second");

		ImmutableStudent s = new ImmutableStudent("ABC", 101, hm, new Date());
		System.out.println(s.name);
		System.out.println(s.regNo);
		// Uncommenting below line causes error
		// s.regNo = 102;
		
		/*hm.put("3", "third");
		
		System.out.println(hm.toString());
		System.out.println(s.getTestMap().toString());*/
		
		Date d = s.getDateOfDiscovery();
		d.setHours(10);
		System.out.println(d);
		System.out.print(s.getDateOfDiscovery());
	}
}
