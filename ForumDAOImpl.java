package com.kaushik.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.kaushik.model.Forum;
import com.kaushik.model.User;

public class ForumDAOImpl implements ForumDAO {

	
	@Autowired
	private SessionFactory sessionFactory;   
	
	public ForumDAOImpl(){}
	
	public ForumDAOImpl(SessionFactory sf){
		this.sessionFactory=sf;
	}
	
	public void saveOrUpdate(Forum f) {
		// TODO Auto-generated method stub
		Session s=sessionFactory.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("Forum dao impl" +  f);
		s.saveOrUpdate(f);
		t.commit();	

	}

	
	public List<Forum> getForumList() {
		@SuppressWarnings("unchecked")
		List<Forum> list = (List<Forum>) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return list;

		/*List<Forum> lst;
		System.out.println("getAllForums()");
		Session ses = sessionFactory.openSession();
		System.out.println("getForumList()session " + ses.isOpen());
		Query qry = ses.createQuery("from Forum where forumstatus='valid'");
		lst = qry.list();
		System.out.println(lst);
		return lst;*/			
	}

	public void deleteForum(Forum f) {
		Session s=sessionFactory.getCurrentSession();
		Transaction t=s.beginTransaction();
		deleteForum(f);
		t.commit();
		
	}

	public Forum getForumid(int fid) {
		String hql = "from Forum where forumid=" + "'" + fid + "'";
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Forum> listUser = (List<Forum>) query.list();

		if (listUser != null && listUser.isEmpty()) {
			return listUser.get(0);
		}
		System.out.println("success");

		return null;
		
		
	}



}