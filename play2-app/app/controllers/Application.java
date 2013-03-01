package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.oregami.data.GameDao;
import org.oregami.data.PlatformDao;
import org.oregami.data.UserDao;
import org.oregami.entities.Game;
import org.oregami.entities.Platform;
import org.oregami.entities.user.User;
import org.oregami.service.IUserService;
import org.oregami.service.ServiceResult;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import be.objectify.deadbolt.java.actions.SubjectPresent;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class Application extends Controller {
  
	@Inject
	public GameDao gameRepository;
    
	@Inject
    public PlatformDao platformRepository;
	
	@Inject
	public IUserService userService;
	
	@Inject
    public UserDao userRepository;	
	
    public Result index() {
        return ok(views.html.index.render());
    }
    
    
    public Result changeLanguage(String lang) {
    	//session("lang", lang);
    	changeLang(lang);
    	return redirect("/languages");
    }
    
    
    public Result listLanguages() {
    	return ok(views.html.languages.render(lang().code().toString()));
    }        
    
    @Transactional
    public Result listGames() {
    	
    	session("lang", "de");
    	
    	List<Game> gameslist = new ArrayList<Game>();
    	Iterator<Game> gamesIter = gameRepository.findAll().iterator();
    	while (gamesIter.hasNext()) {
    		gameslist.add((Game) gamesIter.next());
		}
        return ok(views.html.games.render(gameslist));
    }
    
    @Transactional
    public Result listPlatforms() {
    	List<Platform> list = new ArrayList<Platform>();
    	Iterator<Platform> iter = platformRepository.findAll().iterator();
    	while (iter.hasNext()) {
    		list.add((Platform) iter.next());
		}
        return ok(views.html.platforms.render(list));
    } 
    
    public Result register(){
        return ok(views.html.register.render(null));
    } 
    
    public Result doregister(){
        DynamicForm data = Form.form().bindFromRequest(); // will read each parameter from post and provide their values through map accessor methods
        // accessing a not defined parameter will result in null
        String username = data.get("username");
        String password = data.get("password");
        String email = data.get("email");
        
        System.out.println(userService + "/" + username  + "/" + password + "/" + email);

        User user = new User();
        user.setEmail(email);
        user.setPasswordAndEncryptIt(password);
        user.setUsername(username);
        
        ServiceResult<User> serviceResult = userService.register(user);
       
        return ok(views.html.register.render(serviceResult));
    }  
    
    @SubjectPresent
    public Result admin(){
    	List<User> list = userRepository.findAll();
    	return ok(views.html.admin.render(list));
    }         

    
    public Result login(){
    	return ok(views.html.login.render());
    }
    
    public Result dologin(){
        DynamicForm data = Form.form().bindFromRequest(); // will read each parameter from post and provide their values through map accessor methods
        // accessing a not defined parameter will result in null
        String username = data.get("username");
        String inputPassword = data.get("password");
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encryptedPassword = userRepository.findByUsername(username).getPassword();
		if (passwordEncryptor.checkPassword(inputPassword, encryptedPassword)) {
			session("user", username);
			return redirect("/");
		} else {
			return ok(views.html.login.render());
			// bad login!
		}        
    	
    }        
    
    @Transactional
    public Result showGame(Long gameId) {
//    	return ok();
    	return ok(views.html.game.render(gameRepository.findOne(gameId)));
    }  
    
    public Result logout(){
    	session().clear();
    	return redirect("/");
    }    
    
    
  
}
