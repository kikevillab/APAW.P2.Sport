package es.upm.miw.sports.exceptions;

public class UserExistException extends Exception {
	private static final long serialVersionUID = -642045799876625537L;
	public static final String DESCRIPTION = "El usuario ya existe";

	public UserExistException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public UserExistException() {
		this("");
	}

}
