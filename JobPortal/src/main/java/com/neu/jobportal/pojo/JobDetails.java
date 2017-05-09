package com.neu.jobportal.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@FilterDef(name="activeJobsFilter", parameters = @ParamDef(name="status" , type="string"))
@Filter(name="activeJobsFilter", condition="status like :status")
@Table(name = "jobdetails_table")
public class JobDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="jobId", unique = true, nullable = false)
	private long jobId;
	
	@Column(name = "jobTitle")
	private String jobTitle;
	
	@Column(name = "jobType")
	private String jobType; 		//Full time, Internship, Part Time
	
	@Column(name = "industry")
	private String industry;
	
	@Column(name = "jobDescrition")
	private String jobDescription;
	
	@Column(name = "numberOfOpenings")
	private int numberOfOpenings;
	
	@Column(name = "compensation")
	private int compensation;
	
	@Column(name = "bonusAmount")
	private int bonusAmount;
	
	@Column(name = "status")
	
	private String status;

	@OneToMany(mappedBy = "job",  fetch = FetchType.EAGER)
	private Set<ApplicationStatus> appliedJobs = new HashSet<ApplicationStatus>();
	
	@ManyToOne
//	@JoinColumn(name = "userId", nullable = false)
	private Recruiter recruiter;
	
	
	public JobDetails(long jobId, String jobTitle, String jobType, String industry, String jobDescription, 
			int numberOfOpenings, int compensation, int bonusAmount) {
			this.jobId = jobId;
			this.jobTitle = jobTitle;
			this.jobType = jobType;
			this.industry = industry;
			this.jobDescription = jobDescription;
			this.numberOfOpenings = numberOfOpenings;
			this.compensation = compensation;
			this.bonusAmount = bonusAmount;
	}
	
	public JobDetails(){
		
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public int getNumberOfOpenings() {
		return numberOfOpenings;
	}

	public void setNumberOfOpenings(int numberOfOpenings) {
		this.numberOfOpenings = numberOfOpenings;
	}

	public int getCompensation() {
		return compensation;
	}

	public void setCompensation(int compensation) {
		this.compensation = compensation;
	}

	public int getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(int bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	public Set<ApplicationStatus> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(Set<ApplicationStatus> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}
	
	
}
