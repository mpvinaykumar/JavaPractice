package alogrithms;

public class ReverseString {
	public static void main(String[] args) {
		System.out.println(reverseString1("a,b$c"));
		System.out.println(reverseString2("Ab,c,de!$"));
	}

	//approach1
	public static String reverseString1(String input) {
		char[] inputArr = input.toCharArray();
		int l = 0;
		int r = inputArr.length - 1;
		while (l < r) {
			if (!isAlphabet(inputArr[l])) {
				l++;
			} else if (!isAlphabet(inputArr[r])) {
				r--;
			} else {
				char tempChar = inputArr[l];
				inputArr[l] = inputArr[r];
				inputArr[r] = tempChar;
				l++;
				r--;
			}
		}
		return new String(inputArr);
	}

	//approach2
	public static String reverseString2(String input) {
		char[] inputArr = input.toCharArray();
		int l = 0;
		int r = inputArr.length - 1;
		while (l < r) {
			if (!Character.isAlphabetic(inputArr[l])) {
				l++;
			} else if (!Character.isAlphabetic(inputArr[r])) {
				r--;
			} else {
				char tempChar = inputArr[l];
				inputArr[l] = inputArr[r];
				inputArr[r] = tempChar;
				l++;
				r--;
			}
		}

		return new String(inputArr);
	}

	static boolean isAlphabet(char x) {
		return ((x >= 'A' && x <= 'Z') || (x >= 'a' && x <= 'z'));
	}
}
