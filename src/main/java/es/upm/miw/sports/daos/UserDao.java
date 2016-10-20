package es.upm.miw.sports.daos;

import java.util.List;

import es.upm.miw.sports.entities.Sport;
import es.upm.miw.sports.entities.User;
import es.upm.miw.sports.entities.Vote;

public interface UserDao extends GenericDao<User, Integer>{
	List<User> findUserBySport(Sport sport);
	
	User findByNick(String nick);
}
