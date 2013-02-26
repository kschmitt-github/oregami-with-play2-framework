package org.oregami.data;

import javax.persistence.EntityManager;

import org.oregami.entities.Game;

import com.google.inject.Inject;

public class GameDao extends GenericDAOImpl<Game, Long>{

	@Inject
	public GameDao(EntityManager man) {
		super(man);
	}

}
