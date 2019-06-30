package com.redhat.freelance4j.freelancer.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {
	
	@Query("SELECT f FROM Freelancer f")
	public List<Freelancer> findAll();
	
	@Query("SELECT f FROM Freelancer f WHERE f.freelancerId=(:freelancerId)")
	public Freelancer findById(@Param("freelancerId") long freelancerId);
}
