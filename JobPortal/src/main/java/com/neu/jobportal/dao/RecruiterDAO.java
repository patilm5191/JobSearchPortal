package com.neu.jobportal.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.neu.jobportal.exception.UserException;
import com.neu.jobportal.pojo.Recruiter;
import com.neu.jobportal.pojo.User;

public class RecruiterDAO extends DAO {
	
	public Recruiter registerRecruiter(Recruiter r) throws UserException {
		System.out.println("inside RecruiterDAO");
		try{
		Session session = (Session) DAO.getSession();
		begin();
		session.save(r);
		commit();
		return r;
		}catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating Recruiter " + e.getMessage());
		}
	}

	public Recruiter getRecruiter(User user) {
		Session session = (Session)DAO.getSession();
		begin();
		Query q = session.createQuery("from Recruiter where userId = :userId ");
		q.setLong("userId", user.getUserId());		
		Recruiter r = (Recruiter) q.uniqueResult();
		commit();
		
		return r;
	}
	
}
