package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ArrayPlay {
	int i;
	int iarr[];
	String[] myStringArray;

	private void arrayTypes() {
		// primitives
		int[] myIntArray1 = new int[3];
		int[] myIntArray2 = { 1, 2, 3 };
		int[] myIntArray3 = new int[] { 1, 2, 3 };

		// objects
		String[] myStringArray1 = new String[3];
		String[] myStringArray2 = { "a", "b", "c" };
		String[] myStringArray3 = new String[] { "a", "b", "c" };

		myStringArray = new String[] { "a", "b", "c" };

		// Ragged Array (or Non-rectangular Array)
		int[][] num = new int[5][];
		num[0] = new int[1];
		num[1] = new int[5];
		num[2] = new int[2];
		num[3] = new int[3];

	}

	private void collectionTypes() {
		List<String> sList = new ArrayList<>();
		sList.add("string1");
		System.out.println(sList.size());

		/*
		 * Don't mix arrays and collections. In fact, don't use arrays unless you are
		 * dealing with primitives
		 */
		// List<String>[] sList1 = new ArrayList<>[]; //compile error

		// investigate more on below stmnt
		List<String>[] group = new ArrayList[4];
		group[0] = new ArrayList<>();

		// Constructs an empty list with an initial capacity of ten.
		List<String> group3 = new ArrayList<>();

		ArrayList<ArrayList<String>> group1initialCapacity = new ArrayList<ArrayList<String>>(4);

		// better approach..
		List<List<String>> group2initialCapacity = new ArrayList<List<String>>(4);
		List<List<String>> group2 = new ArrayList<List<String>>();
	}

	private void printArray() {
		int[][] num = { { 1 }, { 1, 2 }, { 1, 2, 3, 4, 5 }, { 1, 2 }, { 1, 2, 3 } };
		// For Accessing:
		for (int i = 0; i < (num.length); i++) {
			for (int j = 0; j < num[i].length; j++)
				System.out.println(num[i][j]);
		}
		// Alternatively:
		for (int[] a : num) {
			for (int i : a) {
				System.out.println(i);
			}
		}

	}

	public static void main(String[] args) {
		String str = "hello";
		char[] cArr = str.toCharArray();
		List charList = new ArrayList<>(Arrays.asList(cArr));
		
		int count1[] = new int[26];

		// create an array of string objs
		String domains[] = { "Practice", "Geeks", "Code", "Quiz" };
		// Here we are making a list named as Collist
		List colList = new ArrayList(Arrays.asList(domains));
		// Collection.sort() method is used here to sort the list elements.
		Collections.sort(colList);

		System.out.println("Array-length with 26:" + count1.length);

		Arrays.sort(cArr);
		Arrays.copyOf(cArr, 0);
		System.arraycopy(cArr, 0, cArr, 0, 0);

		System.out.println(str.indexOf('e'));
		System.out.println(str.contains("hex"));
		System.out.println(str.charAt(0));
		System.out.println(str.toCharArray());

		System.out.println(str.split("h", 2));
		for (String w : str.split("l", -2)) {
			System.out.println(w);
		}

		System.out.println(str.substring(0, 2));
		System.out.println(str.replace('l', 'a'));

	}

}
