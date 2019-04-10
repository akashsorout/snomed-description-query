package com.akashsol.snomed.searchapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.co.bytehub.snomed.searchapi.model.Description;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SnomedDescriptionQueryApplicationTests {

	RestTemplate template = new RestTemplate();
	ObjectMapper mapper = new ObjectMapper();
	@Test
	public void getJson() {
	ResponseEntity<String> res= 	template.getForEntity("http://localhost:8080/descriptions/search?term=cold", String.class);
	System.out.println(res);
	}
	
	@Test
	public void getPoJO() {
		
		Description descObj = template.getForObject("http://localhost:8080/descriptions/search?term=cough", Description.class);
	System.out.println(descObj);
	}

}
