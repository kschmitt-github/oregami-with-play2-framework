/*******************************************************************************
 * Copyright (C) 2012  Oregami.org, Germany http://www.oregami.org
 * 
 * 	This program is free software: you can redistribute it and/or modify
 * 	it under the terms of version 3 or any later version of the
 * 	GNU Affero General Public License as published by the Free Software 
 * 	Foundation.
 * 	
 * 	This program is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 	GNU Affero General Public License for more details.	
 * 	
 * 	You should have received a copy of the GNU Affero General Public License
 * 	along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.oregami.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.oregami.keyobjects.KeyObjects.SystemKey;

@Entity
@NamedQueries({@NamedQuery(name="Game.GetAll", query = "from Game")})
public class Game extends BaseEntity implements WebGui {

	private static final long serialVersionUID = -2362683596950421365L;

	public String tagLineDescription;
	
	public String description;
	
	public String longDescription;
	
	public boolean compilation;
	
	public boolean addOn;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	@JoinTable
	private Set<GameTitle> gameTitleList = new HashSet<GameTitle>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	@OrderBy("system ASC")
	@JoinColumn
	private Set<ReleaseGroup> releaseGroupList = new HashSet<ReleaseGroup>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn
	private Set<Screenshot> screenshotList = new HashSet<Screenshot>();

	public void addReleaseGroup(ReleaseGroup vog) {
		this.releaseGroupList.add(vog);
		vog.setGame(this);
	}

	public void addGameTitle(GameTitle t) {
		this.gameTitleList.add(t);
	}

	public Collection<ReleaseGroup> getReleaseGroupList() {
		return releaseGroupList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Screenshot> getScreenshotList() {
		return screenshotList;
	}

	public void addScreenshot(Screenshot screenshot) {
		this.screenshotList.add(screenshot);
		screenshot.setGame(this);
	}

	public Map<SystemKey, Collection<ReleaseGroup>> getSystemToReleaseGroupMap() {
		Map<SystemKey, Collection<ReleaseGroup>> map = new TreeMap<SystemKey, Collection<ReleaseGroup>>();

		Iterator<ReleaseGroup> rgIterator = getReleaseGroupList().iterator();
		while (rgIterator.hasNext()) {
			ReleaseGroup releaseGroup = (ReleaseGroup) rgIterator.next();
			if (map.get(releaseGroup.getSystem()) == null) {
				map.put(releaseGroup.getSystem(), new ArrayList<ReleaseGroup>());
			}
			map.get(releaseGroup.getSystem()).add(releaseGroup);
		}

		return map;

	}

	@Override
	public String toWebString() {

		String ret = "";
//		ret += "<li>" + this.getMainTitle() + "</li>\n";
		ret += "<li class='folder'>ReleaseGroups (" + releaseGroupList.size() + ")\n";
		ret += "<ul>\n";
		for (ReleaseGroup releaseGroup : this.getReleaseGroupList()) {
			ret += releaseGroup.toWebString();
		}
		ret += "</ul>\n";
		ret += "</li>\n";

		if (this.getScreenshotList().size() > 0) {
			ret += "<li class='folder'>Screenshots (" + this.getScreenshotList().size() + ")\n";
			ret += "<ul>\n";
			ret += "<li><span>";
			for (Screenshot screen : this.getScreenshotList()) {
				ret += "<img style='padding:2px;' src=\"/web/images/screenshots/" + screen.getFileName() + "\">";
			}
			ret += "</span>";
			ret += "</ul>\n";
			ret += "</li>\n";
		}

		return ret;

	}

	public String getTagLineDescription() {
		return tagLineDescription;
	}

	public void setTagLineDescription(String tagLineDescription) {
		this.tagLineDescription = tagLineDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public boolean isCompilation() {
		return compilation;
	}

	public void setCompilation(boolean compilation) {
		this.compilation = compilation;
	}

	public boolean isAddOn() {
		return addOn;
	}

	public void setAddOn(boolean addOn) {
		this.addOn = addOn;
	}

	public Set<GameTitle> getGameTitleList() {
		return gameTitleList;
	}

	public String getMainTitle() {
		String ret = "[missing title for game with id " + getId() + "!]";
		Collection<GameTitle> list = getGameTitleList();
		if (list!=null && !list.isEmpty()) {
			ret = 
//					"mt: " + 
				((GameTitle)list.toArray()[0]).getTitle();
		}
		return ret;
	}
}
