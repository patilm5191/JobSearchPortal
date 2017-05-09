package com.neu.jobportal.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.neu.jobportal.exception.JobException;
import com.neu.jobportal.exception.UserException;
import com.neu.jobportal.pojo.ApplicationStatus;
import com.neu.jobportal.pojo.Candidate;
import com.neu.jobportal.pojo.JobDetails;
import com.neu.jobportal.pojo.Recruiter;

public class JobDAO extends DAO {
	
	public boolean postNewJob(JobDetails job) throws JobException{
	try{
		Session session = (Session) DAO.getSession();

		begin();
		System.out.println("after begin");
		session.save(job);
		System.out.println("after Save");
		commit();
		System.out.println("after commit");
		return true;
		}	
		catch(HibernateException e) {
			rollback();
			throw new JobException("Exception while posting new Job " + e.getMessage());
		}
	}

	public ArrayList<JobDetails> getPostedJobs(Recruiter recruiter) {
		Session session = (Session) DAO.getSession();
		Query q = getSession().createQuery("from JobDetails where recruiter_userId = :userId");
		q.setLong("userId", recruiter.getUserId());
		ArrayList<JobDetails> jobList = (ArrayList<JobDetails>) q.list();
		return jobList;
	}
	
	
	public ArrayList<JobDetails> getJobList(String jobTitle) {
		Session session = (Session) DAO.getSession();
		System.out.println("inside getJobList");
		Filter filter = session.enableFilter("activeJobsFilter");
		filter.setParameter("status", "active");
		Query q = getSession().createQuery("from JobDetails where jobTitle like :jobTitle");
		q.setString("jobTitle", "%"+jobTitle+"%");
		ArrayList<JobDetails> jobList = (ArrayList<JobDetails>) q.list();
//		Criteria crit = session.createCriteria(JobDetails.class);
//		crit.add(Restrictions.ilike("jobTitle","%"+jobTitle+"%"));
//		ArrayList<JobDetails> jobList = (ArrayList<JobDetails>)crit.list();
		session.disableFilter("activeJobsFilter");
		return jobList;
	}
	
	public JobDetails getJobDetail(long jobId){
		Session session = (Session) DAO.getSession();
		Query q = getSession().createQuery("from JobDetails where jobId like :jobId");
		q.setLong("jobId", jobId);
		JobDetails job = (JobDetails) q.uniqueResult();
		return job;
	}
	
	public void updateJob(JobDetails job){
		Session session = (Session) DAO.getSession();
		begin();
		session.merge(job);
		commit();
	}
	
	public void submitApplication(ApplicationStatus j){
		Session session = (Session)DAO.getSession();
		begin();
		session.save(j);
		commit();
	}

	public ArrayList<ApplicationStatus> getAppliedJobsByCandidate(Candidate c) {
		Session session = (Session)DAO.getSession();
		System.out.println("candidateId "+ c.getUserId());
		Query q = session.createQuery("from ApplicationStatus where candidateId = :candidateId");
		q.setLong("candidateId", c.getUserId());
		ArrayList<ApplicationStatus> list = (ArrayList<ApplicationStatus>) q.list();
		return list;
	}

	public ArrayList<ApplicationStatus> getAppliedJobsById(long jobId) {
		Session session = (Session)DAO.getSession();
		System.out.println("jobId "+ jobId);
		Query q = session.createQuery("from ApplicationStatus where jobId = :jobId");
		q.setLong("jobId", jobId);
		ArrayList<ApplicationStatus> list = (ArrayList<ApplicationStatus>) q.list();
//		Criteria crit = session.createCriteria(ApplicationStatus.class);
//		crit.add(Restrictions.eq("jobId",jobId));
//		ArrayList<ApplicationStatus> list = (ArrayList<ApplicationStatus>) crit.list();
		System.out.println("no of record " + list.size() );
		return list;
	}

	public ArrayList<ApplicationStatus> getAppliedJobsBy(long jobId){
		Session session = (Session)DAO.getSession();
		System.out.println("Inside getAppliedJobsBy()");
		Criteria crit = session.createCriteria(ApplicationStatus.class);
		crit.add(Restrictions.eq("jobId",jobId));
		ArrayList<ApplicationStatus> list = (ArrayList<ApplicationStatus>) crit.list();
		
		return list;
	}
	public boolean updateApp(long appId, String status) {
		Session session = (Session)DAO.getSession();
		System.out.println("appId "+ appId);
		Query q = session.createQuery("update ApplicationStatus set status = :status where applicationId = :appId");
		q.setLong("appId", appId);
		q.setString("status", status);
		int result = q.executeUpdate();
		if(result != 0){
			return true;
		}
		else{
			return false;
		}
	}

	public void updateStatus(long jobId, String status) {
		Session session = (Session)DAO.getSession();
		System.out.println("jobId "+ jobId);
		begin();
		Query q = session.createQuery("update JobDetails set status = :status where jobId = :jobId");
		q.setLong("jobId", jobId);
		q.setString("status", status);
		int result = q.executeUpdate();
		commit();
	}
		
}
