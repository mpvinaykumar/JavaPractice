package datastructure;

/*
 * http://www.geeksforgeeks.org/binary-search-preferred-ternary-search/
 * Time Complexity for Binary search = 2clog2n + O(1), (best than Terenary).
 * Time Complexity for Ternary search = 4clog3n + O(1)
*/
class LinearSearch {
	// This function returns index of element x in arr[]
	static int search(int arr[], int n, int x) {
		for (int i = 0; i < n; i++) {
			// Return the index of the element if the element
			// is found
			if (arr[i] == x)
				return i;
		}

		// return -1 if the element is not found
		return -1;
	}
}

class BinarySearch {
	static public int iterative(int[] inputArr, int key) {
		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				return mid;
			}
			if (key < inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	static int recursive(int arr[], int l, int r, int key) {
		if (r >= l) {
			int mid = l + (r - l) / 2;

			// If the element is present at the middle itself
			if (arr[mid] == key)
				return mid;

			// If element is smaller than mid, then it can only be present
			// in left subarray
			if (arr[mid] > key)
				return recursive(arr, l, mid - 1, key);

			// Else the element can only be present in right subarray
			return recursive(arr, mid + 1, r, key);
		}

		// We reach here when element is not present in array
		return -1;
	}
}

class TerenarySearch {
	static int recursive(int arr[], int l, int r, int x) {
		if (r >= l) {
			int mid1 = l + (r - l) / 3;
			int mid2 = mid1 + (r - l) / 3;

			// If x is present at the mid1
			if (arr[mid1] == x)
				return mid1;

			// If x is present at the mid2
			if (arr[mid2] == x)
				return mid2;

			// If x is present in left one-third
			if (arr[mid1] > x)
				return recursive(arr, l, mid1 - 1, x);

			// If x is present in right one-third
			if (arr[mid2] < x)
				return recursive(arr, mid2 + 1, r, x);

			// If x is present in middle one-third
			return recursive(arr, mid1 + 1, mid2 - 1, x);
		}
		// We reach here when element is not present in array
		return -1;
	}
}

public class SearchAlgorithms {

	public static void main(String[] args) {
		int arr[] = { 33, 5, 34, 89, 2, 99, 78 };
		int searchElement = 2;

		int[] arrSort = { 2, 4, 6, 8, 10, 12, 14, 16 };
		int[] arrSort1 = { 6, 34, 78, 123, 432, 900 };

		System.out.println("LinearSearch: found index @ " + LinearSearch.search(arr, arr.length, searchElement));
		System.out.println("Binary-iterative");
		System.out.println("Key 14's position: " + BinarySearch.iterative(arrSort, 14));
		System.out.println("Key 432's position: " + BinarySearch.iterative(arrSort1, 432));
		System.out.println("Binary-Recursive");
		System.out.println("Key 14's position: " + BinarySearch.recursive(arrSort, 0, arrSort.length, 14));
		System.out.println("Key 432's position: " + BinarySearch.recursive(arrSort1, 0, arrSort.length, 432));
		System.out.println("Terenary-iterative");
		System.out.println("Key 14's position: " + TerenarySearch.recursive(arrSort, 0, arrSort.length, 14));
		System.out.println("Key 432's position: " + TerenarySearch.recursive(arrSort1, 0, arrSort.length, 432));

	}
}
