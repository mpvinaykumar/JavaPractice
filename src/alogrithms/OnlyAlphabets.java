package alogrithms;

public class OnlyAlphabets {
	static boolean isAlphabet(char x) {
		return ((x >= 'A' && x <= 'Z') || (x >= 'a' && x <= 'z'));
	}

	public static void main(String[] args) {
		String s = "abcd";
		char[] charArr = s.toCharArray();
		for (char c : charArr) {
			if (!isAlphabet(c)) {
				System.out.println("not only Alphabets");
				break;
			}
		}
	}

}
