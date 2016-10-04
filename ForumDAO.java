package com.kaushik.dao;

import java.util.List;

import com.kaushik.model.Forum;

public interface ForumDAO {
public Forum getForumid(int fid);
	
	public List<Forum> getForumList();
	
	public void deleteForum(Forum f);
	
	public void saveOrUpdate(Forum f);
	
	
//	public Forum getCompleteForum(int fid);
//	public void createForum(Forum f);


}
