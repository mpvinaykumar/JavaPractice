package com.java8.features;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SharedMutable_StreamInterfere {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

		// double the even values and put that into a list.

		// wrong way to do this.
		List<Integer> doubleOfEven = new ArrayList<>();

		numbers
		.stream()
		.filter(e -> e % 2 == 0)
		.map(e -> e * 2)
		.forEach(e -> doubleOfEven.add(e));
		
		/*
		 * mutability is OK, sharing is nice, shared mutability(doubleOfEven, is a
		 * shared variable and we are mutating it) is devils work
		 */

		// friends don't let friends do shared mutation.

		System.out.println(doubleOfEven); // Don't do this.

		// Right way to do this.
		//List
		List<Integer> doubleOfEven2 = numbers.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.collect(toList());
		System.out.println("List:"+ doubleOfEven2);
		
		//Set
		Set<Integer> doubleOfEven3 = numbers.stream()
				.filter(e -> e % 2 == 0)
				.map(e -> e * 2)
				.collect(toSet());
		
		System.out.println("Set:"+ doubleOfEven3);
	}
}
