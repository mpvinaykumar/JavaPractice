package designpatterns;

//http://www.thejavageek.com/2016/07/07/strategy-pattern-implementation/

interface RidingStyle {
	public abstract void ride();
}

class RashRiding implements RidingStyle {

	@Override
	public void ride() {
		System.out.println("Riding like hell, careless and dangerous");
	}

}

class CarefulRiding implements RidingStyle {

	@Override
	public void ride() {
		System.out.println("someone is waiting at home, so riding very carefully");
	}

}

class Bike {
	private RidingStyle ridingStyle;

	public Bike(RidingStyle rs) {
		ridingStyle = rs;
	}

	public RidingStyle getRidingStyle() {
		return ridingStyle;
	}

	public void setRidingStyle(RidingStyle ridingStyle) {
		this.ridingStyle = ridingStyle;
	}

	public void rideBike() {
		ridingStyle.ride();
	}

}

public class Strategy {

	public static void main(String[] args) {

		Bike bike = new Bike(new CarefulRiding());
		bike.rideBike();
		bike.setRidingStyle(new RashRiding());
		bike.rideBike();

	}

}