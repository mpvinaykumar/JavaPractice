package exceptions.exceptionHandling.exceptions;

public class PlayerScoreException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1942617890540891473L;

	public PlayerScoreException(Exception e) {
        super(e);
    }
}
