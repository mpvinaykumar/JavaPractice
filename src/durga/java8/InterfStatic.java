package youtube.durga.java8;

/*Now we can write static method in interface too. In our Village interface, I have declared getVillageId() as an static method. This static method can be accessed in default method as well. */

interface Village {
	void setNumOfPeople(int num);

	void setName(String name);

	static int getVillageId() {
		return 1;
	}

	default String getBusinessType() {
		return "Business type is Farming  and village id:" + getVillageId();
	}
}

class Location implements Village {
	public int noOfPeople;
	public String name;

	@Override
	public void setNumOfPeople(int n) {
		this.noOfPeople = n;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public int getLocationId() {
		return Village.getVillageId();
	}
}

public class InterfStatic {
	public static void main(String[] args) {
		Location lo = new Location();
		System.out.println(lo.getBusinessType());
		System.out.println("Village id:" + Village.getVillageId());
		System.out.println("Location Id:" + lo.getLocationId());
	}
}
