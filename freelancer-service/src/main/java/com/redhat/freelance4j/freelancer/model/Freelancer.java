package com.redhat.freelance4j.freelancer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FREELANCERS")
public class Freelancer implements Serializable {

    private static final long serialVersionUID = -7304814269819778382L;
    
    @Id
    @GeneratedValue
    @Column(name="FREELANCERID")
    private long freelancerId;
    
    @Column(name="FRISTNAME")
    private String firsname;
    
    @Column(name="LASTNAME")
    private String lastname;
    
    @Column(name="EMAIL")
    private String email;
    
    @Column(name="SKILLS")
    private String skills;

    public Freelancer() {
    }

	public long getFreelancerId() {
		return freelancerId;
	}

	public void setFreelancerId(long freelancerId) {
		this.freelancerId = freelancerId;
	}

	public String getFirsname() {
		return firsname;
	}

	public void setFirsname(String firsname) {
		this.firsname = firsname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
