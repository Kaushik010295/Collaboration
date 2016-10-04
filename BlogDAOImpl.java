package com.kaushik.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.kaushik.model.Blog;

import com.kaushik.model.User;

public class BlogDAOImpl implements BlogDAO {

	
	@Autowired
	private SessionFactory sessionFactory;   
	
	public BlogDAOImpl(){}
	
	public BlogDAOImpl(SessionFactory sf){
		this.sessionFactory=sf;
	}
	
	
	public void saveOrUpdate(Blog b) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.getCurrentSession();
		Transaction t= s.beginTransaction();
		System.out.println("Blog dao impl" +  b);
		s.saveOrUpdate(b);
		t.commit();	

	}

	public List<Blog> getBlogList() {
		// TODO Auto-generated method stub
		
		/*List<Blog> lst;
		System.out.println("getAllBlogs()");
		Session ses = sessionFactory.openSession();
//		System.out.println("getBlogList()session " + ses.isOpen());
		Query qry = ses.createQuery("from Blog where blogstatus='valid'");
		lst = qry.list();
		System.out.println(lst);
*/		
		@SuppressWarnings("unchecked")
		List<Blog> list=    (List<Blog>) sessionFactory.getCurrentSession().createCriteria(User.class)
		                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;		
		
	}

	public void deleteBlog(Blog b) {
		Session s=sessionFactory.getCurrentSession();
		Transaction t=s.beginTransaction();
		deleteBlog(b);
		t.commit();

	}

	public Blog getblogid(int bid) {
		String hql = "from Blog where blogid=" + "'" + bid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Blog> listUser = (List<Blog>) query.list();

		if (listUser != null && listUser.isEmpty()) {
			return listUser.get(0);
		}
		System.out.println("success");

		return null;
	}
	
	
	
/*	public Blog getCompleteBlog(int bid){
		Blog b;	
		List<Blog> lst;
		System.out.println("DAO-getCompleteBlog()");
		Session ses = sessionFactory.openSession();
		System.out.println("getBlogList()session " + ses.isOpen());
		Query qry = ses.createQuery("from Blog where blogid="+bid);
		lst = qry.list();
		b=lst.get(0);
		System.out.println(lst);
		return b;		
	}*/


}