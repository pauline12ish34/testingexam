package rw.ac.rca.termOneExam.utils;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import rw.ac.rca.termOneExam.domain.City;
import rw.ac.rca.termOneExam.repository.ICityRepository;
import rw.ac.rca.termOneExam.service.CityService;

public class CityUtilTest {
	@Mock
	private ICityRepository cityRepositoryMock;
	
	@InjectMocks
	private CityService cityService;

	@Test
	public void check40() {
		when(cityRepositoryMock.findAll()).thenReturn(Arrays.asList(new City(1,"Karongi",1,10),
				new City(2,"kibuye",4,100)));
	
	}
	
	 @Test
	    public void getDegree_notMore_than_40() {
	        when(cityRepositoryMock.findAll()).thenReturn(Arrays.asList(new City(1,"Karongi",1,10)));
	        assertTrue(40>cityService.getAll().get(0).getFahrenheit());
	    }

	    
	    @Test
	    public void getDegree_notless_than_10() {
	        when(cityRepositoryMock.findAll()).thenReturn(Arrays.asList(new City(1,"Karongi",1,10)));
	        assertTrue(10< cityService.getAll().get(0).getFahrenheit());
	    }
	
	    @Test
	    public void checkMusanz() {
	        when(cityRepositoryMock.findAll()).thenReturn(Arrays.asList(new City(1,"Karongi",1,10),new City(1,"Kigali",1,10),new City(1,"Musanze",1,10)));
	        assertEquals("Musanze",cityService.getAll().get(2).getName());
	        assertEquals("Musanze",cityService.getAll().get(2).getName());
	    }
}
