package rw.ac.rca.termOneExam.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;


import java.util.Optional;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import rw.ac.rca.termOneExam.domain.City;
import rw.ac.rca.termOneExam.service.CityService;


@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerTest {

	@MockBean
	private CityService cityServiceMock;
	
//	@Test
//	public void getAll_success() throws Exception {
//		List<City> asList = Arrays.asList(new City(1,"Samuel",1,10),
//				new City(2,"Blessing",4,100));
//		when(cityServiceMock.getAll()).thenReturn(asList);
//		
//		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.get("/get-all-students")
//				.accept(MediaType.APPLICATION_JSON);
//
//				MvcResult result = mockMvc
//				.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().json("[{\"id\":1,\"name\":\"pauline\",\"age\":12},{\"id\":2,\"name\":\"Anna\",\"age\":12}]"))
//				.andReturn();
//
//				}
}
