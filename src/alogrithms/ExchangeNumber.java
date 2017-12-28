package alogrithms;

public class ExchangeNumber {
	public static void main(String[] args) {
		int a = 10, b = 12;
		System.out.println(a + ":" + b);
		/*
		 * a = a + b; b = a - b; a = a - b;
		 */
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a + ":" + b);
	}
}
