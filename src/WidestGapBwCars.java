import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//Get the widest gap b/w cars
/**
 * n = 10, and m=4 start = [1, 2, 5, 8] finish = [2, 2, 6, 10] 3-4 and 7
 * 1 2 5 6 8 10
 */

/*
 * 10 2 3 8 | 2 4 9
 */



public class WidestGapBwCars {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Integer arrLength = sc.nextInt();
		List<Integer> inputList = new LinkedList<>();

		Integer[] start = { 2, 3, 8 };
		Integer[] finish = { 2, 4, 9 };

		Set<Integer> travelled = new HashSet<>();
		int i = 0, j = 0;
		int widestGap = 0;

		while (i < start.length && j < finish.length) {
			if (start[i] < finish[j]) {
				travelled.add(start[i]);
				i++;
			} else {
				travelled.add(finish[j]);
				j++;
			}
		}

		if (i < start.length) {
			for (int i2 = i; i2 < start.length; i2++) {
				travelled.add(start[i2]);
			}
		} else {
			for (int j2 = j; j2 < finish.length; j2++) {
				travelled.add(finish[j2]);
			}
		}

		int lastOcuIndex = 0, counter = 0;
		int lastNumber = 0;
		for (Integer currIndex : travelled) {
			if (currIndex - lastOcuIndex > widestGap) {
				widestGap = currIndex - (lastOcuIndex + 1);
			}
			lastOcuIndex = currIndex;
			lastNumber = currIndex;
			counter++;
			if (counter > arrLength)
				break;
		}
		if (counter < arrLength && ((lastNumber - lastOcuIndex) > widestGap)) {
			widestGap = lastNumber - lastOcuIndex;
		}

		System.out.println("Widest Gap: " + widestGap);
	}
}
