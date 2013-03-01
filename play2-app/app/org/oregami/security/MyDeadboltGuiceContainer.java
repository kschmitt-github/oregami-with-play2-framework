package org.oregami.security;

import org.oregami.data.UserDao;

import com.google.inject.Inject;

/**
 * Container Class for "injected" objects
 */
public class MyDeadboltGuiceContainer {
	
	@Inject
	private UserDao userRepository;
	
	protected UserDao getUserRepository() {
		return userRepository;
	}
}