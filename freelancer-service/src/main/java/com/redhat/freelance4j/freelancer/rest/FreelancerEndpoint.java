package com.redhat.freelance4j.freelancer.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redhat.freelance4j.freelancer.model.Freelancer;
import com.redhat.freelance4j.freelancer.service.FreelancerService;

@Path("/")
@Component
public class FreelancerEndpoint {

    @Autowired
    private FreelancerService freelancerService;
    
    @GET
    @Path("/freelancers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Freelancer> getFreelancers() {
        return freelancerService.getFreelancers();
    }
    
    @GET
    @Path("/freelancers/{freelancerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Freelancer getFreelancerById(@PathParam("freelancerId") long freelancerId) {
        return freelancerService.getFreelancerById(freelancerId);
    }
}
