package org.oregami.data;

import javax.persistence.EntityManager;

import org.oregami.entities.user.User;

import com.google.inject.Inject;

public class UserDao extends GenericDAOImpl<User, Long>{

	@Inject
	public UserDao(EntityManager man) {
		super(man);
		// TODO Auto-generated constructor stub
	}

}
