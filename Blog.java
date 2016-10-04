package com.kaushik.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Blog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int BlogID;
	private String BlogTitle;
	private String BlogContent;
	private String BlogCreatedUser;
	private Date BlogCreationDate;
	
	
	public int getBlogID() {
		return BlogID;
	}
	public void setBlogID(int blogID) {
		BlogID = blogID;
	}
	public String getBlogTitle() {
		return BlogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		BlogTitle = blogTitle;
	}
	public String getBlogContent() {
		return BlogContent;
	}
	public void setBlogContent(String blogContent) {
		BlogContent = blogContent;
	}
	public String getBlogCreatedUser() {
		return BlogCreatedUser;
	}
	public void setBlogCreatedUser(String blogCreatedUser) {
		BlogCreatedUser = blogCreatedUser;
	}
	public Date getBlogCreationDate() {
		return BlogCreationDate;
	}
	public void setBlogCreationDate(Date blogCreationDate) {
		BlogCreationDate = blogCreationDate;
	}


}