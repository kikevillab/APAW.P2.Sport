package es.upm.miw.sports.controllers;

import es.upm.miw.sports.daos.DaoFactory;
import es.upm.miw.sports.entities.Sport;
import es.upm.miw.sports.exceptions.SportExistException;

public class SportController {

	public void createSport(String name) throws SportExistException {
		DaoFactory.getFactory().getSportDao().create(new Sport(name));	
	}
	

}
	