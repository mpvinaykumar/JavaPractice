package memoryManagement.EscapingReferences;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();

		records.addCustomer(new Customer("John"));
		records.addCustomer(new Customer("Simon"));

		/*for (Customer next : records.getCustomers().values()) {
			System.out.println(next);
		}*/
		
		for (Customer next : records) {
			System.out.println(next);
		}
		records.iterator().remove();

	}

}
