package ENGX;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ViralFever {

	static int maxRegionSize = 0;
	static int totalStudents = 0;
	static int infectedStudents = 0;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String path = "D://engx//classroom Viral Fever.txt"; // with a modification on line 33 added a comma
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		int N = 50;
		int M = 20;
		int[][] matrix = new int[N][M];
		int[][] progressMatrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			String[] arr = line.split(",");
			for (int j = 0; j < M; j++) {
				int val = Integer.parseInt(arr[j]);
				// scanner.nextInt();
				matrix[i][j] = val;
				progressMatrix[i][j] = val;
				if (0 != val) {
					totalStudents++;
					if (-1 == val) {
						infectedStudents++;
					}
				}
			}
		}
		br.close();
		int timeToInfectAll = 0;
		int previouslyInfectedStudents = infectedStudents;
		while (infectedStudents != totalStudents) {
			infectNeighbours(matrix, progressMatrix, N, M);
			if (previouslyInfectedStudents == infectedStudents) {
				break;
			}
			timeToInfectAll++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					matrix[i][j] = progressMatrix[i][j];
				}
			}
			previouslyInfectedStudents = infectedStudents;
		}

		if (infectedStudents != totalStudents) {
			System.out.println("-1");
		} else {
			System.out.println(timeToInfectAll);
		}
	}

	static void infectNeighbours(int[][] matrix, int[][] progressMatrix, int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == -1) {
					try {
						if (progressMatrix[i - 1][j] == 1) {
							infectedStudents++;
							progressMatrix[i - 1][j] = -1;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
					}
					try {
						if (progressMatrix[i][j + 1] == 1) {
							infectedStudents++;
							progressMatrix[i][j + 1] = -1;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
					}
					try {
						if (progressMatrix[i + 1][j] == 1) {
							infectedStudents++;
							progressMatrix[i + 1][j] = -1;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
					}
					try {
						if (progressMatrix[i][j - 1] == 1) {
							infectedStudents++;
							progressMatrix[i][j - 1] = -1;
						}
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
			}
		}
	}
}