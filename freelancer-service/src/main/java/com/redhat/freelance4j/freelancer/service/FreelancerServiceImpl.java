package com.redhat.freelance4j.freelancer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redhat.freelance4j.freelancer.model.Freelancer;
import com.redhat.freelance4j.freelancer.model.FreelancerRepository;

@Component
public class FreelancerServiceImpl implements FreelancerService {
	
	@Autowired
	private FreelancerRepository freelancerRepository;
	
	@Override
	public List<Freelancer> getFreelancers() {
		return freelancerRepository.findAll();
	}
	
	@Override
	public Freelancer getFreelancerById(long freelancerId) {
		System.out.println("freelancerId:" + freelancerId);
		
		Freelancer freelancer = freelancerRepository.findById(freelancerId);
		
		if( freelancer == null  ) {
			freelancer = new Freelancer();
			freelancer.setFreelancerId(234567);
		}
		
		System.out.println("freelancer.freelancerId:" + freelancer.getFreelancerId());
		
		return freelancer;
	}
}
