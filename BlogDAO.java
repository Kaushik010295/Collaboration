package com.kaushik.dao;

import java.util.List;

import com.kaushik.model.Blog;

public interface BlogDAO {
	 public Blog getblogid(int bid);
	    
		public List<Blog> getBlogList();
		
		public void deleteBlog(Blog b);	
		
		public void saveOrUpdate(Blog b);
		
		
//		public Blog getCompleteBlog(int bid);
//		public void createBlog(Blog b);
}
