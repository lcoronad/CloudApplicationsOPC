package com.redhat.freelance4j.gateway.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.freelance4j.gateway.model.Freelancer;
import com.redhat.freelance4j.gateway.model.Project;
import com.redhat.freelance4j.gateway.service.ProjectService;

@Path("/gateway")
@RequestScoped
public class ProjectResource {
	@Inject
	private ProjectService projectService;
	
    @GET
    @Path("/projects")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getProjects() {
    	List<Project> projects = projectService.getProjects();
        if (projects == null) {
            throw new NotFoundException();
        }
        
        return projects;
    }
	
    @GET
    @Path("/projects/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Project getProject(@PathParam("projectId") String projectId) {
    	Project project = projectService.getProject(projectId);
        if (project == null) {
            throw new NotFoundException();
        }
        
        return project;
    }
    
    @GET
    @Path("/projects/status/{theStatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getProjectsByStatus(@PathParam("theStatus") String theStatus) {
    	List<Project> projects = projectService.getProjectsByStatus(theStatus);
        if (projects == null) {
            throw new NotFoundException();
        }
        
        return projects;
    }
    
    @GET
    @Path("/freelancers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Freelancer> getFreelancers() {
    	List<Freelancer> freelancers = projectService.getFreelancers();
        if (freelancers == null) {
            throw new NotFoundException();
        }
        
        return freelancers;
    }
    
    @GET
    @Path("/freelancers/{freelancerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Freelancer getFreelancersById(@PathParam("freelancerId") String freelancerId) {
    	Freelancer freelancer = projectService.getFreelancer(freelancerId);
        if (freelancer == null) {
            throw new NotFoundException();
        }
        
        return freelancer;
    }
}

