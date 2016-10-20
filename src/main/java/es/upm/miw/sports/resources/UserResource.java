package es.upm.miw.sports.resources;

import es.upm.miw.sports.controllers.UserController;
import es.upm.miw.sports.exceptions.InvalidSportFieldException;
import es.upm.miw.sports.exceptions.InvalidUserException;
import es.upm.miw.sports.exceptions.UserExistException;
import es.upm.miw.sports.wrappers.UserListWrapper;

public class UserResource {

	// POST **/users   body="nick:email"
	public void createUser(String nick, String email) throws UserExistException {
		new UserController().createUser(nick, email);
		
	}
	// GET **/users
	public UserListWrapper userList() {
		return new UserController().userList();
	}

	// GET **/users/search?sports=sportName
	public UserListWrapper userListBySport(String sportName) throws InvalidSportFieldException {
		return new UserController().userListBySport(sportName);
	}

	// PUT **/users/{nick}/sports body="sportName"
	public void addSport(String nick, String sportName) throws InvalidSportFieldException, InvalidUserException {
		new UserController().addSport(nick, sportName);
		
	}

}
