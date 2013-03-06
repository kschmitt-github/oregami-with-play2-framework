package org.oregami.json;

import java.util.Set;

import org.oregami.entities.Game;
import org.oregami.keyobjects.KeyObjects.SystemKey;

public class GameSearch {
	
	public GameSearch(Game g) {
		this.name = g.getMainTitle();
		this.id = g.getId();
		this.description = g.getTagLineDescription();
		String systemString = "";
		Set<SystemKey> systemKeySet = g.getSystemToReleaseGroupMap().keySet();
		boolean init=false;
		for (SystemKey systemKey : systemKeySet) {
			if (init) systemString +="/";
			systemString += systemKey;
			init=true;
		}
		this.system = systemString;
	}
	
	private String name;
	
	private String description;
	
	private Long id;
	
	private String system;
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getValue() {
		return name;
	}
	
	public String getSystem() {
		return system;
	}

}
