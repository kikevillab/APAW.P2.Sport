package es.upm.miw.sports.daos.memory;

import es.upm.miw.sports.daos.DaoFactory;
import es.upm.miw.sports.daos.SportDao;
import es.upm.miw.sports.daos.ThemeDao;
import es.upm.miw.sports.daos.UserDao;
import es.upm.miw.sports.daos.VoteDao;

public class DaoFactoryMemory extends DaoFactory {

	private UserDao userDao;
	private SportDao sportDao;

	public DaoFactoryMemory() {
	}

	@Override
	public UserDao getUserDao() {
		if (userDao == null) {
			userDao = new UserDaoMemory();
		}
		return userDao;
	}

	@Override
	public SportDao getSportDao() {
		if (sportDao == null) {
			sportDao = new SportDaoMemory();
		}
		return sportDao;
	}

}
