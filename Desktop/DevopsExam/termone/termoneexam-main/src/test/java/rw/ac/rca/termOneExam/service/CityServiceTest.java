package rw.ac.rca.termOneExam.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import rw.ac.rca.termOneExam.domain.City;
import rw.ac.rca.termOneExam.dto.CreateCityDTO;
import rw.ac.rca.termOneExam.repository.ICityRepository;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {

	@Mock
	private ICityRepository cityRepositoryMock;
	
	@InjectMocks
	private CityService cityService;
	
	@Test
	public void getAll_withSomeElements() {

		when(cityRepositoryMock.findAll()).thenReturn(Arrays.asList(new City(1,"Karongi",1,10),
				new City(2,"kibuye",4,100)));
		assertEquals("Karongi",cityService.getAll().get(0).getName());
	}
	
	
	@Test
    public void existByname_test() {
		City city= new City(101,"Kigali",16,400);
        when(cityRepositoryMock.existsByName(anyString())).thenReturn(true);
        assertTrue(cityService.existsByName("kigali")==true);
    }
	
	@Test
    public void existByname_fail() {
		City city= new City(101,"Kigali",16,400);
        when(cityRepositoryMock.existsByName(anyString())).thenReturn(true);
        assertFalse(cityService.existsByName("Burera")==true);
    }
	

	@Test 
	public void createsucces(){
		City city= new City(7,"Rutsiro",16,400);
		 CreateCityDTO dto= new  CreateCityDTO("Rutsiro",16.4);
		
		when(cityRepositoryMock.save(any(City.class))).thenReturn(city);
		assertEquals(16,  cityService.save(dto).getWeather());
		
	}
	
	@Test 
	public void createFail(){
		City city= new City(7,"Rutsiro",16,400);
		 CreateCityDTO dto= new  CreateCityDTO("Rutsiro",18);
		
		 when(cityRepositoryMock.getById(city.getId())).thenReturn(city);
		 assertTrue(cityService.save(dto)==null);

	}
	
	
	
	@Test
	public void getById() {
		City city= new City(7,"Rutsiro",16,400);
		when(cityRepositoryMock.getById(city.getId())).thenReturn(city);
		assertEquals(city,cityService.getById(7));
		
	}

}
