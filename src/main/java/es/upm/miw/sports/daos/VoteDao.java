package es.upm.miw.sports.daos;

import java.util.List;

import es.upm.miw.sports.entities.Vote;

public interface VoteDao extends GenericDao<Vote, Integer> {
	List<Integer> findValueByThemeId(int themeId);
}
