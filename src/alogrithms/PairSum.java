package alogrithms;

import java.util.Arrays;

public class PairSum {
	private static final int MAX = 100000; // Max size of Hashmap

	static void printpairs(int arr[], int sum) {
		// Declares and initializes the whole array as false
		boolean[] binmap = new boolean[MAX];

		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];

			// checking for condition
			if (temp >= 0 && binmap[temp]) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
			}
			binmap[arr[i]] = true;
		}
	}

	// Main to test the above function
	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, 8 };
		int n = 16;
		printpairs(A, n);
	}
}

class SumOfPairs { 
	  
    public void pairedElements(int arr[], int sum) 
    { 
        int low = 0; 
        int high = arr.length - 1; 
  
        while (low < high) { 
            if (arr[low] + arr[high] == sum) { 
                System.out.println("The pair is : ("
                                   + arr[low] + ", " + arr[high] + ")"); 
            } 
            if (arr[low] + arr[high] > sum) { 
                high--; 
            } 
            else { 
                low++; 
            } 
        } 
    } 
  
    public static void main(String[] args) 
    { 
        int arr[] = { 2, 3, 4, -2, 6, 8, 9, 11 }; 
        Arrays.sort(arr); 
  
        SumOfPairs sp = new SumOfPairs(); 
        sp.pairedElements(arr, 6); 
    } 
} 