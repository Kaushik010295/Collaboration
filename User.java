
package com.kaushik.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class User implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -6605904831388500008L;

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int uid;
    
    @NotEmpty(message="Firstname cannot be empty")
    private String ufirstname;
    private String role;

    
    
    
    public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@NotEmpty(message="Lastname cannot be empty")
	private String ulastname;
    
    
    
    @NotEmpty(message="Username cannot be empty")
	private String username;
    
    
    
    
    @NotEmpty(message="Password cannot be empty")
	private String upassword;
    
    @NotEmpty(message="Confirm Password cannot be empty")
    @Transient
     private String uconfirmpassword;
       
    @NotEmpty(message="Email cannot be empty")
	private String uemail;
    
    
    
    public String getUconfirmpassword() {
		return uconfirmpassword;
	}
	public void setUconfirmpassword(String uconfirmpassword) {
		this.uconfirmpassword = uconfirmpassword;
	}
	@NotEmpty(message="Phonenumber cannot be empty")
	private String uphonenumber;
    
    
    public String getUphonenumber() {
		return uphonenumber;
	}
	public void setUphonenumber(String uphonenumber) {
		this.uphonenumber = uphonenumber;
	}
	private boolean isAdmin;
    
    @Column(name="enabled")
    private boolean isEnabled;
    
    
    
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUfirstname() {
		return ufirstname;
	}
	public void setUfirstname(String ufirstname) {
		this.ufirstname = ufirstname;
	}
	public String getUlastname() {
		return ulastname;
	}
	public void setUlastname(String ulastname) {
		this.ulastname = ulastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	


	
}