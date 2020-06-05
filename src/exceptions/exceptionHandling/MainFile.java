package exceptions.exceptionHandling;

public class MainFile {
	public static void main(String[] args) {
		Exceptions exceptions = new Exceptions();
		
		exceptions.getPlayerScoreMultipleCatchBlocks("Test");
		
		exceptions.getPlayerScoreMultipleCatchBlocksAlternative("Test");
	}
}
