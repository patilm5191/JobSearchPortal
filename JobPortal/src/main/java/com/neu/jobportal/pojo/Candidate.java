package com.neu.jobportal.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.FetchMode;

import javax.persistence.JoinColumn;;


@Entity
@Table(name="candidate_table")
@PrimaryKeyJoinColumn(name = "userId")
public class Candidate extends User{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "candidateID", unique = true, nullable = false)
//	private long candidateID;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "zipCode")
	private String zipCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "phoneNumber")
	private long phoneNumber;

	@OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER)
	private Set<ApplicationStatus> appliedJobs = new HashSet<ApplicationStatus>();
	
	public Candidate(){
		
	}

	public Candidate(String firstName, String lastName, String zipCode, String city, String state, String country, String emailId, long phoneNumber ){
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}

//	public long getCandidateID() {
//		return candidateID;
//	}
//
//	public void setCandidateID(long candidateID) {
//		this.candidateID = candidateID;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<ApplicationStatus> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(Set<ApplicationStatus> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}

	
}
