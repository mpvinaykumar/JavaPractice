public class TryReturns {

	public String tryMethod() {
		try {
			// System.exit(0); no o/p (close the JVM)
			return "try";
		} catch (Exception e) {
			return "catch";
		} finally {
			System.out.println("i don't know if this will get printed out.");
			return "finally"; // over rides try return"try"
		}
	}

	public static void main(String[] args) {
		System.out.println(new TryReturns().tryMethod());
	}
}


/* 

The only times finally won't be called are:
If you call System.exit()
If the JVM crashes first
If there is an infinite loop in the try block
If the power turns off
-----------------------------
O/P:-
i don't know if this will get printed out.
finally
*/