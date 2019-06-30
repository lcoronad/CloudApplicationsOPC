package com.redhat.freelance4j.gateway.model;

import java.io.Serializable;

public class Freelancer implements Serializable {

    private static final long serialVersionUID = -7304814269819778382L;
    
    private long freelancerId;
    
    private String firsname;
    
    private String lastname;
    
    private String email;
    
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
