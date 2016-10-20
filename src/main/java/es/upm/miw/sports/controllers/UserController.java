package es.upm.miw.sports.controllers;

import java.util.List;

import es.upm.miw.sports.daos.DaoFactory;
import es.upm.miw.sports.entities.Sport;
import es.upm.miw.sports.entities.User;
import es.upm.miw.sports.exceptions.InvalidSportFieldException;
import es.upm.miw.sports.exceptions.InvalidUserException;
import es.upm.miw.sports.exceptions.UserExistException;
import es.upm.miw.sports.wrappers.UserListWrapper;
import es.upm.miw.sports.wrappers.UserWrapper;

public class UserController {

	public UserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return userListWrapper;
	}

	public UserListWrapper userListBySport(String sportName) throws InvalidSportFieldException {
		Sport sport = DaoFactory.getFactory().getSportDao().findByName(sportName);
		if(sport == null)
			throw new InvalidSportFieldException(sportName);
		
		List<User> userList = DaoFactory.getFactory().getUserDao().findUserBySport(sport);
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return userListWrapper;

	}

	public void addSport(String nick, String sportName) throws InvalidSportFieldException, InvalidUserException {
		Sport sport = DaoFactory.getFactory().getSportDao().findByName(sportName);		
		if(sport == null)
			throw new InvalidSportFieldException(sportName);
		
		User user = DaoFactory.getFactory().getUserDao().findByNick(nick);		
		if(user == null)
			throw new InvalidUserException(nick);
		
		user.addSport(sport);
		DaoFactory.getFactory().getUserDao().update(user);
		
	}

	public void createUser(String nick, String email) throws UserExistException {
		User user = DaoFactory.getFactory().getUserDao().findByNick(nick);
		if (user != null)
			throw new UserExistException(nick);
		
		DaoFactory.getFactory().getUserDao().create(new User(nick, email));
	
		
	}

}
