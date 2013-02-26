package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.oregami.data.GameDao;
import org.oregami.data.PlatformDao;
import org.oregami.entities.Game;
import org.oregami.entities.Platform;

import play.mvc.Controller;
import play.mvc.Result;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class Application extends Controller {
  
	@Inject
	public GameDao gameRepository;
    
	@Inject
    public PlatformDao platformRepository;
	
    @com.google.inject.persist.Transactional
    public Result index() {

    	List<Game> gameslist = new ArrayList<Game>();
    	
    	Iterator<Game> gamesIter = gameRepository.findAll().iterator();
    	while (gamesIter.hasNext()) {
    		gameslist.add((Game) gamesIter.next());
		}
    	
        return ok(views.html.index.render(gameslist));
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
    
    
    @Transactional
    public Result showGame(Long gameId) {
//    	return ok();
    	return ok(views.html.game.render(gameRepository.findOne(gameId)));
    }    
  
}
