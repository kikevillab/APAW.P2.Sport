package es.upm.miw.sports.resources;

import es.upm.miw.sports.controllers.UserController;
import es.upm.miw.sports.wrappers.UserListWrapper;

public class UserResource {

	// POST **/users   body="nick:email"
	public void createUser(String nick, String email) {
		new UserController().createUser(nick, email);
		
	}
	// GET **/users
	public UserListWrapper userList() {
		return new UserController().userList();
	}

	// GET **/users/search?sports=sportName
	public UserListWrapper userListBySport(String sportName) {
		return new UserController().userListBySport(sportName);
	}

	// PUT **/users/{nick}/sports body="sportName"
	public void addSport(String nick, String sportName) {
		new UserController().addSport(nick, sportName);
		
	}

}
