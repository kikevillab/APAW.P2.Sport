package es.upm.miw.sports.wrappers;

public class UserWrapper {

	private String nick;
	private String email;

	public UserWrapper() {
	}
	
	public UserWrapper(String nick, String email) {
		this.setNick(nick);
		this.setEmail(email);
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "{\"nick\":\"" + nick +  "\",\"email\":\"" + email +"\"}";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
