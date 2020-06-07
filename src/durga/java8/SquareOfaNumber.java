package youtube.durga.java8;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class SquareOfaNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		int num = sc.nextInt();

		/** Java-7 **/
		System.out.println("** Java-7 **");
		System.out.println("Your squared number is: " + square(num));
		System.out.println("is Even?: " + isEven(num));

		
		/** Java-8 **/
		Function<Integer, Integer> square = i -> i * i;
		Predicate<Integer> isEvenPrdicate = i -> i % 2 == 0;

		System.out.println("\n** Java-8 **");
		System.out.println("Your squared number is: " + square.apply(num));
		System.out.println("is Even?: " + isEvenPrdicate.test(num));
	}

	/** Java-7 **/
	public static int square(int num) {
		return num * num;
	}

	public static boolean isEven(int num) {
		return num % 2 == 0;
	}

}

