package es.upm.miw.sports.daos.memory;

import java.util.HashMap;
import java.util.List;

import es.upm.miw.sports.daos.SportDao;
import es.upm.miw.sports.entities.Sport;

public class SportDaoMemory extends GenericMemoryDao<Sport> implements SportDao {

	public SportDaoMemory() {
		this.setMap(new HashMap<Integer,Sport>());
	}

	@Override
	protected Integer getId(Sport entity) {
		return entity.getId();
	}

	@Override
	protected void setId(Sport entity, Integer id) {
		entity.setId(id);
	}

	@Override
	public Sport findByName(String name) {
		List<Sport> sportList = this.findAll();
		if(sportList.size() == 0) return null;
		for(Sport sport : sportList){
			if(sport.getName().equals(name)){
				return sport;
			}
		}
		
		return null;
	}

	

}