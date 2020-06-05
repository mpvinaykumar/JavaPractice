package basics;

public class TypeCasting {

	public static void main(String args[]) {
		long long1, long2;
		int int1, int2;
		char char1, char2;
		boolean bool1 = false;
		long1 = 66;
		int1 = 65;
		char1 = (char) int1; // A
		System.out.println("int => char:= " + char1);

		char2 = (char) long1; // B
		System.out.println("int => char:= " + char1);

		int2 = char1;
		System.out.println("char => int:= " + int2);

		//long2 = bool1; //throws Error 'Type-MisMatch
		//System.out.println("char => int:= " + long2);
	}
}
