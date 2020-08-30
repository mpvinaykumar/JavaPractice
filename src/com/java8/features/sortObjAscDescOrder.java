package com.java8.features;
import java.util.Arrays;
import java.util.Comparator;

public class sortObjAscDescOrder {
	public static void main(String[] args) {

		String[] albums = { "The Beatles,Please Please Me", "Bob Marley and the Wailers,Natty Dread",
				"Pink Floyd,The Dark Side of the Moon", "The Doors,The Doors23", "The Doors,The Doors2" };

		Arrays.stream(albums)
				.sorted(Comparator.comparing((String e) -> e.split(",")[0]).thenComparing((String e) -> e.split(",")[1],
						Comparator.reverseOrder()))
				// .sorted(Comparator.reverseOrder())
				.forEach(System.out::println);
		;

	}
}
