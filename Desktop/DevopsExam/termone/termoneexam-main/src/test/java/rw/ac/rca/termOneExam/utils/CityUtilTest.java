package rw.ac.rca.termOneExam.utils;

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
	
}
