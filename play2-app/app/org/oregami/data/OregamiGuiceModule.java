package org.oregami.data;

import org.oregami.entities.Game;
import org.oregami.entities.Platform;
import org.oregami.entities.user.User;
import org.oregami.service.IUserService;
import org.oregami.service.UserServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class OregamiGuiceModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(new TypeLiteral<GenericDAO<Game, Long>>() {}).to(GameDao.class);
		bind(new TypeLiteral<GenericDAO<User, Long>>() {}).to(UserDao.class);
		bind(new TypeLiteral<GenericDAO<Platform, Long>>() {}).to(PlatformDao.class);
		
		bind(IUserService.class).to(UserServiceImpl.class);

	}
}