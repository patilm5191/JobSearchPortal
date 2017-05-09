package com.neu.jobportal.dao;

import org.hibernate.Session;

import com.neu.jobportal.pojo.CompanyDetails;

public class CompanyDAO extends DAO {
	
	public CompanyDetails addNewCompany(CompanyDetails company){
	System.out.println("inside Company DAO");
	Session session = (Session) DAO.getSession();
	begin();
	session.save(company);
	commit();
	return company;
	}
}
