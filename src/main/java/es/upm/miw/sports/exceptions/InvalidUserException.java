package es.upm.miw.sports.exceptions;

public class InvalidUserException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "El usuario no existe";

	public InvalidUserException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidUserException() {
		this("");
	}

}
