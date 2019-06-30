package com.redhat.freelance4j.gateway.rest.client;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.freelance4j.gateway.model.Project;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ProjectsClient {
	
	@GET
	@Path("/projects")
	public List<Project> getProjects( );
}
