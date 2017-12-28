package basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	String street;
	String country;

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return this.street;
	}

	public String getCountry() {
		return this.country;
	}

	@Override
	public String toString() {
		return new StringBuffer(" Street : ").append(this.street).append(" Country : ").append(this.country).toString();
	}
}

class WriteObject {

	static {

		Address address = new Address();
		address.setStreet("wall street");
		address.setCountry("united states");

		try {

			FileOutputStream fout = new FileOutputStream(".\\address.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(address);
			oos.close();
			System.out.println("Done");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

class ReadObject {
	static {

		Address address;

		try {

			FileInputStream fin = new FileInputStream(".\\address.ser");
			ObjectInputStream ois = new ObjectInputStream(fin);
			address = (Address) ois.readObject();
			ois.close();

			System.out.println(address);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

public class Serialization {
	public static void main(String[] args) {
		new WriteObject();
		new ReadObject();
		File directory = new File("./");
		System.out.println(directory.getAbsolutePath());
	}
}
