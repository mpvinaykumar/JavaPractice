package alogrithms;

public class OnlyDigits {
	public static boolean isDigit(char c) {
		/*int x = (int) c - (int) '0';
		if (x < 0 || x > 9) {
			return false;
		}
		return true;*/
		if(c>='0' && c<='9') {
			return true;
		}else {
			return false;
		}

	}

	public static void main(String[] args) {
		String s = "09823a4";
		char[] charArr = s.toCharArray();
		for (char c : charArr) {
			if (!isDigit(c)) {
				System.out.println("not only digits");
				break;
			}
		}
	}
}
