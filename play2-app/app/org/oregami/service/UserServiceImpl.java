package org.oregami.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import org.oregami.data.UserDao;
import org.oregami.entities.user.Role;
import org.oregami.entities.user.User;
import org.oregami.entities.user.UserStatus;
import org.oregami.keyobjects.KeyObjects.RoleKey;
import org.oregami.keyobjects.KeyObjects.UserStatusKey;
import org.oregami.util.validation.UserValidator;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class UserServiceImpl implements IUserService {

    @Inject
    private UserDao userRepository;
    
    @Inject
    private UserValidator validator;
    
//    @Autowired
//    private MailSender mailSender;
//
//    public MailSender getMailSender() {
//        return mailSender;
//    }
// 
//    public void setMailSender(MailSender mailSender) {
//        this.mailSender = mailSender;
//    }
 
    public void uponSuccessfulRegistration(){
 
    	System.out.println("sending email...");
    	try {
			new SendMailUsingAuthentication().postMail(new String[]{"gene@kultpower.de"}, "Betreff", "Nachricht", "demo@oregami.org");
		} catch (AuthenticationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
//        List<String> userEmailIds = new ArrayList<String>();
//        userEmailIds.add("gene@kultpower.de");
//        
//		SimpleMailMessage[] mailMessageArray = new SimpleMailMessage[userEmailIds.size()];
//		
//        Iterator<String> iterator = userEmailIds.iterator();
//        for (int index = 0; iterator.hasNext(); index ++){
// 
//            SimpleMailMessage message = new SimpleMailMessage();
//            String toAddress = iterator.next();
//            message.setTo(toAddress);
//            message.setSubject("User Registration successful");
//            message.setText("The user '" + toAddress + "' is successfully registered");
//            message.setFrom("gene@oregami.org");
//            mailMessageArray[index] = message;
//        }
//        System.out.println("Sending email ....");
//        try {
//        	mailSender.send(mailMessageArray);
//		} catch (Exception e) {
//			//TODO what shall we do with this error?
//			e.printStackTrace();
//		}
    }    
    
    @Override
    @Transactional
    public ServiceResult<User> register(User userData) {
        
//    	List<ServiceError> errorMessages = new ArrayList<ServiceError>();
//    	errorMessages.add(new ServiceError(new ServiceErrorContext("password"), "wrong pwd"));
//    	User user = new User();
    	
        List<ServiceError> errorMessages = validator.validateForRegister(userData);

        User user = null;

        if (errorMessages.size() == 0) {
            user = userData;
            
            UserStatus userStatus = new UserStatus();
            String hash = UUID.randomUUID().toString();
            userStatus.setVerifyHash(hash);
            userStatus.setCreationDate(new Timestamp(System.currentTimeMillis()));
            userStatus.setUserStatus(UserStatusKey.Registration);
            user.addUserStatus(userStatus);
            
            Role userRole = new Role();
            userRole.setRoleKey(RoleKey.User);
			user.getRoleList().add(userRole);
            
            user.setPasswordAndEncryptIt(user.getPassword());
            userRepository.save(user);
            
            uponSuccessfulRegistration();
        }

        return new ServiceResult<User>(user, errorMessages);
    }

	
}
