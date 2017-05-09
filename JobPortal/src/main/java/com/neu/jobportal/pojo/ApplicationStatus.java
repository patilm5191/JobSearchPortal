package com.neu.jobportal.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "applicationstatus_table")
public class ApplicationStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="applicationId", unique = true, nullable = false)
	private long applicationId;
	
	@ManyToOne
	@JoinColumn(name = "candidateId")
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn(name = "jobId")
	private JobDetails job;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Transient
	private CommonsMultipartFile resume; 
	
	@Column(name = "filename")
	private String filename; 
	
	public ApplicationStatus(){
		
	}

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public JobDetails getJob() {
		return job;
	}

	public void setJob(JobDetails job) {
		this.job = job;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CommonsMultipartFile getResume() {
		return resume;
	}

	public void setResume(CommonsMultipartFile resume) {
		this.resume = resume;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}


	
}
