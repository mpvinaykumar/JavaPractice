package basics;

import java.util.StringTokenizer;

/**
 * https://www.javatpoint.com/string-tokenizer-in-java
*/	

public class StringTokenizerTest {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("my-name is,khan", " ");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
