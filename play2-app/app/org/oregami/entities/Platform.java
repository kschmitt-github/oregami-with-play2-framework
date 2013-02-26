package org.oregami.entities;

import javax.persistence.Entity;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQueries({@NamedQuery(name="Platform.GetAll", query = "from Platform")})
public class Platform extends BaseEntity {

	private String title;

	public Platform() {
		
	}
	
	public Platform(String title) {
		this.setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private static final long serialVersionUID = 5712943108921434646L;

}
