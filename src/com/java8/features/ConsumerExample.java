package com.java8.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConsumerExample {
	public static void main(String[] args) {
		// Consumer to display a number
		Consumer<Integer> display = a -> System.out.println(a);

		// Implement display using accept()
		display.accept(10);

		// Consumer to multiply 2 to every integer of a list
		Consumer<List<Integer>> modify = list -> {
			for (int i = 0; i < list.size(); i++)
				list.set(i, 2 * list.get(i));
		};

		// Consumer to display a list of numbers
		Consumer<List<Integer>> dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));

		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(3);

		// Implement modify using accept()
		modify.accept(list);

		// Implement dispList using accept()
		dispList.accept(list);

		//modify.andThen(null).accept(list);

		List<Object> output = new ArrayList<Object>();
		List<Long> input = new ArrayList<Long>();
		//Collections.copy(input, output);

		//List<Number> numbers = new ArrayList<Integer>();// gets compile time error

	}

}


