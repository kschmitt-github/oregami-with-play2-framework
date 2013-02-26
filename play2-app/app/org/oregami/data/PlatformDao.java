package org.oregami.data;

import javax.persistence.EntityManager;

import org.oregami.entities.Platform;

import com.google.inject.Inject;

public class PlatformDao extends GenericDAOImpl<Platform, Long>{

	@Inject
	public PlatformDao(EntityManager man) {
		super(man);
		// TODO Auto-generated constructor stub
	}

}
