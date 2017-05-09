package com.neu.jobportal.dao;


import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.Session;

import com.neu.jobportal.exception.UserException;
import com.neu.jobportal.pojo.Candidate;
import com.neu.jobportal.pojo.User;

public class UserDAO extends DAO{
	
	public User validateLogin(String username, String password) throws UserException {
	try{
		begin();
		Query q = getSession().createQuery("from User where username = :username and password = :password");
		q.setString("username", username);
		q.setString("password", password);			
		User user = (User) q.uniqueResult();
		commit();
		return user; 
		} catch (HibernateException e) {
		rollback();
		throw new UserException("Could not get user " + username, e);
		}
	}
	
	public Candidate getCandidateDetails(User user){
		begin();
		Query q = getSession().createQuery("from Candidate where userId = :userId ");
		q.setLong("userId", user.getUserId());		
		Candidate c = (Candidate) q.uniqueResult();
		commit();
		return c;
	}
	
	public Candidate registerCandidate(Candidate c) throws UserException {
		
		System.out.println("inside candidateDAO");
//		Candidate candidate = new Candidate(c.getFirstName(),c.getLastName(),c.getZipCode(),c.getCity(),c.getState(),c.getCountry(),c.getEmailID(),c.getPhoneNumber());
//		candidate.setUsername(c.getUsername());
//		candidate.setPassword(c.getPassword());
//		candidate.setUserType("candidate");
//		candidate.setUserStatus("Active");
//		
//		System.out.println(candidate.getUserId());
//		System.out.println(candidate.getUsername());
//		System.out.println(candidate.getFirstName());
//		System.out.println(candidate.getLastName());
//		getSession().save(candidate);
		try{
			Session session = (Session) DAO.getSession();
	
			begin();
			System.out.println("after begin");
			session.save(c);
			System.out.println("after Save");
			commit();
			System.out.println("after commit");
			return c;
		}catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating Candidate: " + e.getMessage());
		}
	}
	
	public void updateCandidate(Candidate c) throws UserException{
		try{
			Session session = (Session) DAO.getSession();
			begin();
			session.merge(c);
			commit();
		}catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while Updating user: " + e.getMessage());
		}
	}

	public Candidate getCandidateById(long candidateId) {
		Session session = (Session) DAO.getSession();
		begin();
		Query q = session.createQuery("from Candidate where userId = :userId");
		q.setLong("userId", candidateId);
		Candidate c = (Candidate) q.uniqueResult();
		return c;
	}
}

