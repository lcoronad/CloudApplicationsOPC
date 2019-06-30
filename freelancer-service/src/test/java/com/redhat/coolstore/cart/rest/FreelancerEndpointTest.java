package com.redhat.coolstore.cart.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.redhat.freelance4j.freelancer.FreelancerServiceApplication;
import com.redhat.freelance4j.freelancer.model.Freelancer;
import com.redhat.freelance4j.freelancer.model.FreelancerRepository;
import com.redhat.freelance4j.freelancer.service.FreelancerService;

import io.restassured.http.ContentType;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FreelancerServiceApplication.class)
public class FreelancerEndpointTest {
	
	/*@TestConfiguration
    static class FreelancerServiceImplTestContextConfiguration {
  
        @Bean
        public FreelancerService freelancerService() {
            return new FreelancerServiceImpl();
        }
    }*/
 
	@MockBean
    private FreelancerService freelancerService;
 
    @MockBean
    private FreelancerRepository freelancerRepository;
	
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
    }
    
    @Test
    public void retrieveFreelancers() throws Exception {
        given().get("/freelancers")
            .then()
            .assertThat()
            .statusCode(200)
            .contentType(ContentType.JSON);
            //.body("freelancerId", equalTo(234567));
    }

    @Test
    public void retrieveFreelancerById() throws Exception {
        given().get("/freelancers/{freelancerId}", 234567)
            .then()
            .assertThat()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("freelancerId", equalTo(234567));
    }

}
