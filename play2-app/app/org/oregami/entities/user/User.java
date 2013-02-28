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
package org.oregami.entities.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.oregami.entities.BaseEntity;
import org.oregami.keyobjects.KeyObjects.RoleKey;

//@Audited
@Entity
@NamedQueries ({
@NamedQuery(
	    name="findByUsername",
	    query="FROM User u WHERE username = :UserName"
	),
@NamedQuery(
	    name="User.GetAll",
	    query="FROM User u"
	)
})
public class User extends BaseEntity {

	private static final long serialVersionUID = 4594670372719416989L;

	@Column(unique=true, nullable=false) 
	private String username;
	
	private String email;
	
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<UserStatus> userStatusList = new ArrayList<UserStatus>();
	
	

	private String avatar; //TODO Typ "Picture"
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Role> roleList = new ArrayList<Role>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPasswordAndEncryptIt(String plaintext) {
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(plaintext);
		
		/* for login:
		 StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
String encryptedPassword = passwordEncryptor.encryptPassword(userPassword);
...
if (passwordEncryptor.checkPassword(inputPassword, encryptedPassword)) {
  // correct!
} else {
  // bad login!
}
see http://www.jasypt.org/encrypting-passwords.html
		 */
		
		this.password = encryptedPassword;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public boolean hasRole(RoleKey role) {
		return this.roleList.contains(role);
	}
	
	public void addUserStatus(UserStatus us) {
		this.getUserStatusList().add(us);
	}	
	
	@Override
	public String toString() {
		String ret = "";
		ret += "[User " + getId() + ": " + username + ", " + email + "]";
		
		return ret;
	}

	public Collection<UserStatus> getUserStatusList() {
		return userStatusList;
	}

//	public void setUserStatusList(Collection<UserStatus> userStatusList) {
//		this.userStatusList = userStatusList;
//	}

	
}
