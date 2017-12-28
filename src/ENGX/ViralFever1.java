package ENGX;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class ViralFever1 {

	private static final String FILE_PATH = "D://engx//classroom Viral Fever.txt";
	private static final int ROW_COUNT = 50;
	private static final int COLUMN_COUNT = 20;

	private static int arr[][] = new int[ROW_COUNT][COLUMN_COUNT];
	private static Set<String> positionSet = new HashSet<>();
	private static boolean checkOnceFlag = false;

	private static int minimalTime = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = null;
		try {
			Path path = Paths.get(FILE_PATH);
			reader = Files.newBufferedReader(path);

			for (int i = 0; i < ROW_COUNT; i++) {
				String line = reader.readLine();
				String[] values = line.split(",");
				int k = 0;
				for (int j = 0; j < values.length; j++) {
					arr[i][j] = Integer.parseInt(values[k]);
					k++;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (reader != null)
				reader.close();
		}

		printArray();
		feverSpreadLogic();
		System.out.println("Minimal Value : " + minimalTime);

	}

	private static void feverSpreadLogic() {
		for (int i = 0; i < ROW_COUNT; i++) {
			for (int j = 0; j < COLUMN_COUNT; j++) {
				if (arr[i][j] == -1) {

					if (i != 0 && arr[i - 1][j] == 1) {
						positionSet.add(Integer.toString(i - 1) + " " + j);
					}
					if (i != (ROW_COUNT - 1) && arr[i + 1][j] == 1) {
						positionSet.add(Integer.toString(i + 1) + " " + Integer.toString(j));
					}
					if (j != 0 && arr[i][j - 1] == 1) {
						positionSet.add(Integer.toString(i) + " " + Integer.toString(j - 1));
					}
					if (j != (COLUMN_COUNT - 1) && arr[i][j + 1] == 1) {
						positionSet.add(Integer.toString(i) + " " + Integer.toString(j + 1));
					}
				} else if (arr[i][j] == 1) {
					if (!checkOnceFlag && checkIfImpossible(i, j)) {
						minimalTime = -1;
						break;
					}
				}
			}
			if (minimalTime == -1) {
				break;
			}
		}
		checkOnceFlag = true;
		System.out.println(positionSet);
		if (!positionSet.isEmpty() && minimalTime != -1) {
			manipulateDataOfArray();
			feverSpreadLogic();
		}

	}

	private static void manipulateDataOfArray() {
		minimalTime++;
		for (String positionString : positionSet) {
			String[] values = positionString.split(" ");
			arr[Integer.parseInt(values[0])][Integer.parseInt(values[1])] = -1;
		}
		positionSet.clear();
	}

	private static boolean checkIfImpossible(int i, int j) {

		boolean isImpossible = true;
		if (i != 0 && arr[i - 1][j] != 0) {
			isImpossible = false;
		}
		if (i != (ROW_COUNT - 1) && arr[i + 1][j] != 0) {
			isImpossible = false;
		}
		if (j != 0 && arr[i][j - 1] != 0) {
			isImpossible = false;
		}
		if (j != (COLUMN_COUNT - 1) && arr[i][j + 1] != 0) {
			isImpossible = false;
		}
		return isImpossible;
	}

	private static void printArray() {
		for (int i = 0; i < ROW_COUNT; i++) {
			for (int j = 0; j < COLUMN_COUNT; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}