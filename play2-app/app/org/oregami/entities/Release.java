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

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.oregami.keyobjects.KeyObjects.DistributionKey;


@Entity
@Table(name="GameRelease")
public class Release extends BaseEntity implements WebGui {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private DistributionKey distribution;
	
	@ManyToOne
	private ReleaseGroup releaseGroup;
	
	private String description;

	@OneToMany(mappedBy = "release", cascade = CascadeType.ALL, orphanRemoval=true)
	@OrderBy("yearOfRelease")
	private Set<CountryRelease> countryReleaseList = new HashSet<CountryRelease>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<Photo> photoList = new HashSet<Photo>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<Screenshot> screenshotList = new HashSet<Screenshot>();
	
	public Release() {};
	
	public Release(String description, DistributionKey distribution) {
		this.description = description;
		this.distribution = distribution;
	}
	
	public void setReleaseGroup(
			ReleaseGroup releaseGroup) {
		this.releaseGroup = releaseGroup;
	}

	public void addCountryRelease(CountryRelease countryRelease) {
		this.countryReleaseList.add(countryRelease);
		countryRelease.setRelease(this);
	}

	public DistributionKey getDistribution() {
		return distribution;
	}

	public String getDescription() {
		return description;
	}

	public Set<CountryRelease> getCountryReleaseList() {
		return countryReleaseList;
	}

	@Override
	public String toWebString() {
		String ret = "";
		
		ret += "<li>" + this.getDistribution().toString() + " (" + this.getDescription() + ")\n";
		
		ret += "<ul>\n";
		
		Set<CountryRelease> countryReleaseList = this.getCountryReleaseList();
		ret += "<li class='folder'>Countries (" + getCountryReleaseList().size() + ")\n";
		ret += "<ul>\n";
		for (CountryRelease country : countryReleaseList) {
			ret += country.toWebString();
		}
		ret += "</ul>\n";
		ret += "</li>\n";
		
		
		ret += "</ul>\n";
		ret += "</li>\n";
		
		return ret;
	}

	public Set<Photo> getPhotoList() {
	    return photoList;
	}

	public void setPhotoList(Set<Photo> param) {
	    this.photoList = param;
	}

	public Set<Screenshot> getScreenshotList() {
	    return screenshotList;
	}

	public void setScreenshotList(Set<Screenshot> param) {
	    this.screenshotList = param;
	}
	
	public void addScreenshot(Screenshot screenshot) {
		this.screenshotList.add(screenshot);
//		screenshot.setGame(this);
	}
	
	public void addPhoto(Photo photo) {
		this.photoList.add(photo);
//		screenshot.setGame(this);
	}	
	
}
