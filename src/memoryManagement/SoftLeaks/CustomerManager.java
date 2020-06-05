package memoryManagement.SoftLeaks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerManager {

	private List<Customer> customers = new ArrayList<Customer>();
	private int nextId = 0;

	public void addCustomer(Customer customer) {
		synchronized (this) {
			customer.setId(nextId);
			nextId++;
		}
		customers.add(customer);
	}

	public Customer getNextCustomer() {
		// should do:

		/**
		 * Run the application with Arguments(VM Arguments: -Xmx50m) max heap size for
		 * this program is 50MB.
		 */
		/*
		 * Problem: SoftLeak, memory is not being freed. After a while system slow-down
		 * and get crash. can observe graphically in Java-VisualVM
		 */
		// return customers.get(0);

		/* Solution: remove the customer from List*/
		Customer result = null;
		synchronized (this) {
			if (customers.size() > 0) {
				result = customers.remove(0);
			}
		}
		return result;
	}

	public void howManyCustomers() {
		int size = 0;
		size = customers.size();
		System.out.println("" + new Date() + " : " + size);
	}

	public void displayCustomers() {
		synchronized (customers) {
			for (Customer c : customers) {
				System.out.println(c.toString());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
