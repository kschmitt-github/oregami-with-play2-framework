package org.oregami.util.validation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.oregami.data.UserDao;
import org.oregami.entities.user.User;
import org.oregami.service.ServiceError;
import org.oregami.service.ServiceErrorContext;

import com.google.inject.Inject;

public class UserValidator {

	@Inject
    private UserDao userDaoManager;


    public List<ServiceError> validateForRegister(User userData) {
        List<ServiceError> errors = new ArrayList<ServiceError>();
        errors.addAll(validateRequiredFields(userData));

        if (userDaoManager.findByUsername(userData.getUsername())!=null) {
            errors.add(new ServiceError(new ServiceErrorContext("username"),"org.oregami.user.username.alreadyExists"));
        }

        return errors;

    }

    public List<ServiceError> validateRequiredFields(User userData) {
        List<ServiceError> errorMessages = new ArrayList<ServiceError>();

        if (StringUtils.isEmpty(userData.getUsername())) {
            errorMessages.add(new ServiceError(new ServiceErrorContext("username"), "org.oregami.user.username.isEmpty"));
        }

        if (StringUtils.isEmpty(userData.getEmail())) {
        	errorMessages.add(new ServiceError(new ServiceErrorContext("email"), "org.oregami.user.email.isEmpty"));
        }

        if (StringUtils.isEmpty(userData.getPassword())) {
        	errorMessages.add(new ServiceError(new ServiceErrorContext("password"), "org.oregami.user.password.isEmpty"));        	
        }

        return errorMessages;
    }
}
