package alogrithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountDuplicateCharacters {
	public static void printDuplicateCharacters(String word) {
		char[] characters = word.toCharArray();
		// build HashMap with character and number of times they appear in String
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (Character ch : characters) {
			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch) + 1);
			} else {
				charMap.put(ch, 1);
			}
		} // Iterate through HashMap to print all duplicate characters of String
		Set<Map.Entry<Character, Integer>> entrySet = charMap.entrySet();
		System.out.printf("List of duplicate characters in String '%s' %n", word);
		for (Map.Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() > 1) {
				System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
			}
		}
	}

	public static void main(String arg[]) throws Exception {
		String res = "";
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		while (a.length() > 0) {
			int c = 0;
			for (int j = 0; j < a.length(); j++) {
				if (a.charAt(0) == a.charAt(j))
					c = c + 1;
			}
			res = res + a.charAt(0) + "=" + c + "\n";
			String k[] = a.split(a.charAt(0) + "");
			a = new String("");
			for (int i = 0; i < k.length; i++)
				a = a + k[i];
		}
		System.out.println(res);
	}
}

// Read more:http://
// www.java67.com/2014/03/how-to-find-duplicate-characters-in-String-Java-program.html#ixzz4tch3knFS
