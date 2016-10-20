package es.upm.miw.sports.controllers;

import es.upm.miw.sports.daos.DaoFactory;
import es.upm.miw.sports.entities.Sport;

public class SportController {

	public void createSport(String name) {
		DaoFactory.getFactory().getSportDao().create(new Sport(name));
		
	}
	

}
