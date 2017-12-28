package ENGX;

import java.util.LinkedList;
import java.util.Queue;

public class ClassroomViral {
	public final static int R = 50;
	public final static int C = 20;

	static class StudentPosition {
		int x = 0;
		int y = 0;

		StudentPosition(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean isValid(int i, int j) {
		return (i >= 0 && j >= 0 && i < R && j < C);
	}

	static boolean isDelim(StudentPosition temp) {
		return (temp.x == -1 && temp.y == -1);
	}

	static boolean checkAll(int arr[][]) {
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (arr[i][j] == 1)
					return true;
		return false;
	}

	static int spreadFever(int arr[][]) {
		Queue<StudentPosition> studentQueue = new LinkedList<>();
		StudentPosition temp;
		int ans = 0;
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (arr[i][j] == -1)
					studentQueue.add(new StudentPosition(i, j));
		studentQueue.add(new StudentPosition(-1, -1));

		while (!studentQueue.isEmpty()) {
			boolean flag = false;

			while (!isDelim(studentQueue.peek())) {
				temp = studentQueue.peek();

				if (isValid(temp.x + 1, temp.y + 1) && arr[temp.x + 1][temp.y] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x + 1][temp.y] = -1;

					temp.x++;
					studentQueue.add(new StudentPosition(temp.x, temp.y));

					temp.x--;
				}
				if (isValid(temp.x - 1, temp.y) && arr[temp.x - 1][temp.y] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x - 1][temp.y] = -1;
					temp.x--;
					studentQueue.add(new StudentPosition(temp.x, temp.y));
					temp.x++;
				}

				if (isValid(temp.x, temp.y + 1) && arr[temp.x][temp.y + 1] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x][temp.y + 1] = -1;
					temp.y++;
					studentQueue.add(new StudentPosition(temp.x, temp.y));
					temp.y--;
				}
				if (isValid(temp.x, temp.y - 1) && arr[temp.x][temp.y - 1] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x][temp.y - 1] = -1;
					temp.y--;
					studentQueue.add(new StudentPosition(temp.x, temp.y));
				}
				studentQueue.remove();
			}
			studentQueue.remove();
			if (!studentQueue.isEmpty()) {
				studentQueue.add(new StudentPosition(-1, -1));
			}
		}

		return (checkAll(arr)) ? -1 : ans;

	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, -1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, 0, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, 0, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, 0, 1, -1, -1, -1, 1, 1, -1, 0, 1, -1, 1, 0, 0, 0, 1 },
				{ 0, 1, 0, 1, -1, 1, -1, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ -1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, 0, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, -1, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, 0, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, 0, 0, 1 },
				{ 0, 1, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, 0, 1, 0, -1, 0, 1, 1, 1, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ -1, 0, 0, 1, -1, 1, 0, -1, 0, 1, -1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, 0, 1, 0, -1, 0, 1 },
				{ 1, -1, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, 0, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 1, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 01, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, -1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, -1, 0, 1, 0, 1, -1, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, -1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, 0, 0, 1 },
				{ 1, 0, 0, -1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, 0, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, -1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 0, 1, 0, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, 0, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, 1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, 1, 1, 0, 0, 1, -1, -1, 0, -1, 0, 1 },
				{ 1, 0, 0, 1, -1, 1, 0, -1, 0, -1, 1, 0, 0, 1, -1, 1, 0, 0, 0, 1 },
				{ -1, 0, 0, 1, -1, 1, 0, -1, 0, 1, -1, 0, 0, -1, -1, -1, 0, -1, 0, 1 }

		};

		System.out.println(spreadFever(arr));
	}
}