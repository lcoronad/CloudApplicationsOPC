package com.redhat.freelance4j.gateway.service;

import java.io.StringReader;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import com.redhat.freelance4j.gateway.model.Freelancer;
import com.redhat.freelance4j.gateway.model.Project;

@ApplicationScoped
public class ProjectService {

    private WebTarget projectsService;
    private WebTarget projectService;
    private WebTarget projectStatusService;
    private WebTarget freelancersService;
    private WebTarget freelancerService;
    @Inject
    @ConfigurationValue("projects.service.url")
    private String projectUrl;
    @Inject
    @ConfigurationValue("freelancer.service.url")
    private String freelancerUrl;
    
    public List<Project> getProjects() {
    	Response response = projectsService.request(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() == 200) {
        	List <Project> projects = response.readEntity(new GenericType<List<Project>>() {});
        	
            return projects;
        } else if (response.getStatus() == 404) {
            return null;
        } else {
            throw new ServiceUnavailableException();
        }
    }


    public Project getProject(String projectId) {
        Response response = projectService.resolveTemplate("projectId", projectId).request(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() == 200) {
        	JsonObject jsonResponse = Json.createReader(new StringReader(response.readEntity(String.class))).readObject();
        	
        	Project project = new Project();
        	project.setOwnerEmailName(jsonResponse.getString("ownerEmailName"));
        	project.setOwnerFirstName(jsonResponse.getString("ownerFirstName"));
        	project.setOwnerLastName(jsonResponse.getString("ownerLastName"));
        	project.setProjectDescription(jsonResponse.getString("projectDescription"));
        	project.setProjectId(jsonResponse.getString("projectId"));
        	project.setProjectStatus(jsonResponse.getString("projectStatus"));
        	project.setProjectTitle(jsonResponse.getString("projectTitle"));
        	
        	return project;
        } else if (response.getStatus() == 404) {
            return null;
        } else {
            throw new ServiceUnavailableException();
        }
    }
    
    public List<Project> getProjectsByStatus(String theStatus) {
    	Response response = projectStatusService.resolveTemplate("theStatus", theStatus).request(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() == 200) {
        	List <Project> projects = response.readEntity(new GenericType<List<Project>>() {});
        	
            return projects;
        } else if (response.getStatus() == 404) {
            return null;
        } else {
            throw new ServiceUnavailableException();
        }
    }
    
    public List<Freelancer> getFreelancers() {
    	Response response = freelancersService.request(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() == 200) {
        	List <Freelancer> freelancers = response.readEntity(new GenericType<List<Freelancer>>() {});
        	
            return freelancers;
        } else if (response.getStatus() == 404) {
            return null;
        } else {
            throw new ServiceUnavailableException();
        }
    }


    public Freelancer getFreelancer(String freelancerId) {
        Response response = freelancerService.resolveTemplate("freelancerId", freelancerId).request(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() == 200) {
        	JsonObject jsonResponse = Json.createReader(new StringReader(response.readEntity(String.class))).readObject();
        	
        	Freelancer freelancer = new Freelancer();
        	freelancer.setEmail(jsonResponse.getString("email"));
        	freelancer.setFirsname(jsonResponse.getString("firsname"));
        	freelancer.setFreelancerId(jsonResponse.getInt("freelancerId"));
        	freelancer.setLastname(jsonResponse.getString("lastname"));
        	freelancer.setSkills(jsonResponse.getString("skills"));
        	
        	return freelancer;
        } else if (response.getStatus() == 404) {
            return null;
        } else {
            throw new ServiceUnavailableException();
        }
    }

    @PostConstruct
    public void init() {
    	projectsService = ((ResteasyClientBuilder)ClientBuilder.newBuilder())
                .connectionPoolSize(10).build().target(projectUrl).path("/projects");
    	projectService = ((ResteasyClientBuilder)ClientBuilder.newBuilder())
                .connectionPoolSize(10).build().target(projectUrl).path("/projects").path("{projectId}");
    	projectStatusService = ((ResteasyClientBuilder)ClientBuilder.newBuilder())
                .connectionPoolSize(10).build().target(projectUrl).path("/projects/status").path("{theStatus}");
    	freelancersService = ((ResteasyClientBuilder)ClientBuilder.newBuilder())
                .connectionPoolSize(10).build().target(freelancerUrl).path("/freelancers");
    	freelancerService = ((ResteasyClientBuilder)ClientBuilder.newBuilder())
                .connectionPoolSize(10).build().target(freelancerUrl).path("/freelancers").path("{freelancerId}");
    }

}
