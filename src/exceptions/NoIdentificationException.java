package exceptions;
public class NoIdentificationException extends Exception {
	private static final long serialVersionUID = 1L;
	public NoIdentificationException() {
		super("You need put a identification");
	}

}
