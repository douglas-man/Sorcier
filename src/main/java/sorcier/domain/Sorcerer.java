package sorcier.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.apache.commons.lang3.builder.EqualsBuilder;
//import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Sorcerer {
	
	private Sorcerer() {}  /* --- Hibernate Rule # 1 --- */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="fullname")
	private String fullname;
//	private String lastName;
    @Column(name="email")
	private String email;
	
	@Column(name="updateByEmail")
	private boolean updateByEmail;
	
//	public Sorcerer() {}
	
	public Sorcerer(Long id, String username, String password, String fullname,  // String lastName,
	                 String email, boolean updateByEmail) {
//		this(null, username, password, fullname, lastName, email);
//	}
	
//	public Sorcerer(Long id, String username, String password, String fullname, String lastName, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
//		this.lastName = lastName;
		this.email = email;
		this.updateByEmail = updateByEmail;
	}
	
	public Long getId() {
	        return id;	
	}
	
	public String getUsername() {
		    return username;
	}
 
//    public void setUsername(String username) {
//		this.username = username;
//	}
	
	public String getPassword() {
		    return password;
	}
	
//	public void setPassword(String password) {
//		this.password = password;
//	}
	
//	public Long getId() {
//		return id;
//	} 
	
//	public void setId(Long id) {
//		this.id = id;
//	}
	
	public String getFullName() {
		    return fullname;
	}
	
//	public void setFirstName(String fullname) {
//		this.fullname = fullname;
//	}
	
//	public String getLastName() {
//		return lastName;
//	}
	
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
	
	public String getEmail() {
		    return email;
	}
	
	public boolean isUpdateByEmail() {
		    return updateByEmail;
	}
	
//	@Override
//	public boolean equals(Object that) {
//		return EqualsBuilder.reflectionEquals(this, that, "fullname", "lastName", "username", "password", "email");
//	}
	
//	@Override
//	public int hashCode() {
//		return HashCodeBuilder.reflectionHashCode(this, "fullname", "lastName", "username", "password", "email");
//	}	
	
}