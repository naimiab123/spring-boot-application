package io.nai.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;  //<- put this: s'il y a eu le message: “JPA ManytoMany Relationship “ JoinColumn cannot be resolved to a type” 
 
@Entity
public class AppUser {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long id;
	@Column(unique=true)
	private String username;
	private String password;
	private boolean enable;             //pour activer ou desactiver les utilisateurs
	
	@ManyToMany(fetch=FetchType.EAGER) //pour collecter les roles d'un utilisateur cas ou findbyId
	@JoinTable(name="USER_ROLES",
	joinColumns= {@JoinColumn(name="USER_ID")},
	inverseJoinColumns= {@JoinColumn(name="ROLE_ID")})
	private List<AppRole> roles;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public AppUser() {
		
	}
	
	public AppUser(Long id, String username, String password, boolean enable, List<AppRole> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.roles = roles;
	}
	public AppUser(String username, String password, boolean enable, List<AppRole> roles) {
		super();
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.roles = roles;
	}
	
	public AppUser(String username, String password, boolean enable) {
		super();
		this.username = username;
		this.password = password;
		this.enable = enable;
	}
	public List<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(List<AppRole> roles) {
		this.roles = roles;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppUser other = (AppUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
