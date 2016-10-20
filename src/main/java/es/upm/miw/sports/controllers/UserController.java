package es.upm.miw.sports.controllers;

import java.util.List;

import es.upm.miw.sports.daos.DaoFactory;
import es.upm.miw.sports.entities.Sport;
import es.upm.miw.sports.entities.User;
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

	public UserListWrapper userListBySport(String sportName) {
		Sport sport = DaoFactory.getFactory().getSportDao().findByName(sportName);
		if(sport != null){
			List<User> userList = DaoFactory.getFactory().getUserDao().findUserBySport(sport);
			UserListWrapper userListWrapper = new UserListWrapper();
			for (User user : userList) {
				userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
			}
			return userListWrapper;
		}
		return null;
	}

	public void addSport(String nick, String sportName) {
		Sport sport = DaoFactory.getFactory().getSportDao().findByName(sportName);
		if(sport != null){
			User user = DaoFactory.getFactory().getUserDao().findByNick(nick);
			user.addSport(sport);
			DaoFactory.getFactory().getUserDao().update(user);
		}
		
	}

	public boolean createUser(String nick, String email) {
		User user = DaoFactory.getFactory().getUserDao().findByNick(nick);
		if (user != null) {
			DaoFactory.getFactory().getUserDao().create(new User(nick, email));
			return true;
		} else {
			return false;
		}
		
	}

}
