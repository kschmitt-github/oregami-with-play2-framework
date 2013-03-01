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
import org.oregami.html.HtmlHeader;
import org.oregami.service.IUserService;
import org.oregami.service.ServiceResult;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import be.objectify.deadbolt.java.actions.Group;
import be.objectify.deadbolt.java.actions.Restrict;

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
    
    private HtmlHeader header(String title) {
    	return new HtmlHeader().title(title);
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
        return ok(views.html.games.render(header("_games_"),gameslist));
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
    
    @Restrict({@Group("Admin")})
    public Result admin(){
    	List<User> list = userRepository.findAll();
    	return ok(views.html.admin.render(list));
    }         

    
    public Result login(){
    	return ok(views.html.login.render(null));
    }
    
    public Result dologin(){
        DynamicForm data = Form.form().bindFromRequest(); // will read each parameter from post and provide their values through map accessor methods
        // accessing a not defined parameter will result in null
        String username = data.get("username");
        String inputPassword = data.get("password");
        
        if (username==null || inputPassword==null || username.length()==0 || inputPassword.length()==0) {
        	return ok(views.html.login.render("org.oregami.login.fillAllData"));
        }
        
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		User loadedUser = userRepository.findByUsername(username);
		if (loadedUser==null) {
			return ok(views.html.login.render("org.oregami.login.unknownUser"));
		}
		
		if (passwordEncryptor.checkPassword(inputPassword, loadedUser.getPassword())) {
			session("user", username);
			return redirect("/");
		} else {
			return ok(views.html.login.render("org.oregami.login.wrongPassword"));
			// bad login!
		}        
    	
    }        
    
    @Transactional
    public Result showGame(Long gameId) {
//    	return ok();
    	Game game = gameRepository.findOne(gameId);
    			
		return ok(views.html.game.render(header("_game_: " + game.getMainTitle()), game));
    }  
    
    public Result logout(){
    	session().clear();
    	return redirect("/");
    }    
    
    
  
}
