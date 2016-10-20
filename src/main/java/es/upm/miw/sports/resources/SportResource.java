package es.upm.miw.sports.resources;

import es.upm.miw.sports.controllers.SportController;
import es.upm.miw.sports.exceptions.InvalidSportFieldException;
import es.upm.miw.sports.exceptions.SportExistException;

public class SportResource {

	// POST **/sports   body="sportName"
	public void createSport(String name) throws InvalidSportFieldException, SportExistException{
		this.validateField(name);
		new SportController().createSport(name);
		
	}
	
	private void validateField(String field) throws InvalidSportFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidSportFieldException(field);
		}
	}

}
