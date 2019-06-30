package com.redhat.coolstore.cart.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.redhat.freelance4j.freelancer.FreelancerServiceApplication;
import com.redhat.freelance4j.freelancer.model.Freelancer;
import com.redhat.freelance4j.freelancer.model.FreelancerRepository;
import com.redhat.freelance4j.freelancer.service.FreelancerService;
import com.redhat.freelance4j.freelancer.service.FreelancerServiceImpl;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FreelancerServiceApplication.class)
public class FreelancerServiceImplTest {
	
	@Autowired
    private FreelancerService freelancerService;
	 
    @MockBean
    private FreelancerRepository freelancerRepository;
	
	/*@TestConfiguration
    static class FreelancerServiceImplTestContextConfiguration {
  
        @Bean
        public FreelancerService freelancerService() {
            return new FreelancerServiceImpl();
        }
    }*/
	
    @Before
    public void setUp() {
    	Freelancer freelancer = new Freelancer();
    	freelancer.setFreelancerId(234567);
    	
    	Freelancer freelancer2 = new Freelancer();
    	freelancer2.setFreelancerId(234568);
    	
    	List<Freelancer> freelancers = new ArrayList<Freelancer>();
    	freelancers.add(freelancer);
    	freelancers.add(freelancer2);
    	
        Mockito.when(freelancerRepository.findById(234567))
          .thenReturn(freelancer);
        
        Mockito.when(freelancerRepository.findAll())
          .thenReturn(freelancers);
        
        //freelancerService = new FreelancerServiceImpl();
    }

    @Test
    public void getFreelancers() throws Exception {

        List<Freelancer> freelancers = freelancerService.getFreelancers();

        assertThat(freelancers, notNullValue());
        assertThat(freelancers.size(), equalTo(2));
    }
    
    @Test
    public void getFreelancerById() throws Exception {

        Freelancer freelancer = freelancerService.getFreelancerById(234567);

        assertThat(freelancer, notNullValue());
        assertThat(freelancer.getFreelancerId(), equalTo(234567L));
    }
}
