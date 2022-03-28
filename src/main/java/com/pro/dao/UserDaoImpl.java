package com.pro.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.pro.entity.User;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;

	
	public long save(User user) {
		sessionFactory.openSession().save(user);
		return user.getMobileNo();
		
	}

	public void update(long mobileNo, User user) {
		Session session = sessionFactory.openSession();
	      session.beginTransaction();
	      User u1 =session.get(User.class, mobileNo);
	      
	      u1.setName(user.getName());
	      u1.setAddress(user.getAddress());
	      u1.setMobileNo(user.getMobileNo());
	      session.update(u1);
	      session.getTransaction().commit();
	     
	}

	public void delete(long mobileNo) {
		 Session session = sessionFactory.openSession();
	      session.beginTransaction();
	      User u2 = session.get(User.class, mobileNo);
	      session.delete(u2);
	      session.getTransaction().commit();
		
	}

	

	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<User> cq = cb.createQuery(User.class);
	      Root<User> root = cq.from(User.class);
	      cq.select(root);
	      Query<User> query = session.createQuery(cq);
	      return query.getResultList();

	}

	public User getUser(long mobileNo) {
		return sessionFactory.openSession().get(User.class, mobileNo);
	}


}
