package es.upm.miw.sports.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.sports.daos.UserDao;
import es.upm.miw.sports.entities.Sport;
import es.upm.miw.sports.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	public UserDaoMemory() {
		this.setMap(new HashMap<Integer, User>());
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);

	}
	
	@Override
	public List<User> findUserBySport(Sport sport) {
		List<User> userList = this.findAll();
		List<User> returnUserList = new ArrayList<>();
		for (User user : userList) {
			if (user.getSports().contains(sport)) {
				returnUserList.add(user);
			}
		}
		return returnUserList;
	}

	@Override
	public User findByNick(String nick) {
		List<User> userList = this.findAll();
		for (User user : userList) {
			if (user.getNick() == nick) {
				return user;
			}
		}
		return null;
		
	}

}