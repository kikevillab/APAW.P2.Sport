package es.upm.miw.sports.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int id;
	private String nick;
	private String email;
	private List<Sport> sports;

	public User(String nick, String email) {
		this.nick = nick;
		this.email = email;
		sports = new ArrayList<Sport>();
	}

	public String getEmail() {
		return email;
	}

	public String getNick() {
		return nick;
	}

	public List<Sport> getSports() {
		return sports;
	}

	public void setNick(String nick) {
		this.nick = nick;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void addSport(Sport sport){
		sports.add(sport);
	}


}
