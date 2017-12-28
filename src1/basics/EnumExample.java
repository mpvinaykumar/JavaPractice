package basics;


public class EnumExample {
	enum Day {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}
	
	enum Season {
		//always static final
		WINTER(5), SPRING(10), SUMMER(15), FALL(20);

		private int value;

		/*
		 * You can not create an instance of enums by using new operator in Java
		 * because the constructor of Enum in Java can only be private and Enums
		 * constants can only be created inside Enums itself.
		 */
		private Season(int value) {
			this.value = value;
		}
	}

	public static void main(String args[]) {
		Day day = Day.MONDAY;

		switch (day) {
		case SUNDAY:
			System.out.println("sunday");
			break;
		case MONDAY:
			System.out.println("monday");
			break;
		default:
			System.out.println("other day");
		}
		
		for (Season s : Season.values())
			System.out.println(s + " " + s.value);
		
		System.out.println(Season.FALL.value+"-"+Season.FALL.ordinal());
		
	}
}

