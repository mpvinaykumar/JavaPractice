package exceptions.chainedexception;

import java.util.concurrent.TimeoutException;

public class InheritanceException {
	public static void main(String[] args) throws TimeoutException, MyCheckedException {
		Exceptions exceptions = new MoreExceptions();
		exceptions.loadAllPlayers("file");
	}
}

class Exceptions {
	public void loadAllPlayers(String playersFile) throws TimeoutException, MyCheckedException {
		//throw new TimeoutException();
		// ...
	}
}

class FewerExceptions extends Exceptions {
	@Override
	public void loadAllPlayers(String playersFile) {
		// overridden
	}
}

class MoreExceptions extends Exceptions {
	@Override
	public void loadAllPlayers(String playersFile) throws MyCheckedException {
		// overridden
		throw new MyCheckedException("From MoreExceptions");
	}
}

//Custom Checked Exception by extending EXCEPTION 
class MyCheckedException extends Exception {

	public MyCheckedException() {
	}

	public MyCheckedException(String message) {
		super(message);
	}
}

//Custom Un-Checked Exception by extending RuntimeEXCEPTION
class MyUnCheckedException extends RuntimeException {

	public MyUnCheckedException() {
	}

	public MyUnCheckedException(String message) {
		super(message);
	}

}