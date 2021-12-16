package rw.ac.rca.termOneExam.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Objects;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import rw.ac.rca.termOneExam.domain.City;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CityControllerIntegrationTest {
	
	@Autowired 
	private TestRestTemplate restTemplate;
	@Test
	public void getAll_success() throws JSONException {
		String response = this.restTemplate.getForObject("/all", String.class);
		
		JSONAssert.assertEquals("[]", response, false);
		JSONAssert.assertEquals("[{id:101},{id:102},{id:103},{id:104}]", response, false);
	}
	
	
	
	@Test
    public void create_testSuccess() {
        City city1 = new City(20L,"Bugesera",10,200);
        ResponseEntity<City> response = restTemplate.postForEntity("/add", city1, City.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("dd", Objects.requireNonNull(response.getBody()).getName());
    }
    @Test
    public void create_testDuplicateName() {
        City city1 = new City(700,"Rutsiro",24,89);
        ResponseEntity<String> response = restTemplate.postForEntity("/add", city1, String.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
    }
    
    @Test
    public void findById_Success() {
        ResponseEntity<String> response = restTemplate.getForEntity("/102", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void findById_testNotFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/109", String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
    

}
