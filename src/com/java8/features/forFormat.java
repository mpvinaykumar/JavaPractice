package com.java8.features;

import java.util.Random;
import java.util.function.IntUnaryOperator;

public class forFormat {

	public static void main(String[] args) {

		IntUnaryOperator f1 = i -> i + 1;
		System.out.println("i + 1: " + f1.applyAsInt(4));

		IntUnaryOperator f2 = i -> i * i;
		System.out.println("i * i: " + f2.applyAsInt(4));

		System.out.println(f1.andThen(f2).applyAsInt(4));
		
		System.out.println(new Random().nextInt(12));

	}
}
