package com.redhat.freelance4j.gateway.model;

import java.io.Serializable;

public class Project implements Serializable {

    private static final long serialVersionUID = -6994655395272795259L;

    private String projectId;
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerEmailName;
    private String projectTitle;
    private String projectDescription;
    private String projectStatus;

    public Project() {

    }

    public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public String getOwnerEmailName() {
		return ownerEmailName;
	}

	public void setOwnerEmailName(String ownerEmailName) {
		this.ownerEmailName = ownerEmailName;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
