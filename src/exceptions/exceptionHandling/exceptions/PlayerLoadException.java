package exceptions.exceptionHandling.exceptions;

import java.io.IOException;

public class PlayerLoadException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9088876708902031238L;

	public PlayerLoadException(IOException io) {
		super(io);
	}

}
