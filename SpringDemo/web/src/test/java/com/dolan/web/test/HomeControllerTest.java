package com.dolan.web.test;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import com.dolan.web.controller.HomeController;

public class HomeControllerTest {
	@Test
	public void testHome() throws Exception{
		HomeController controller;
		controller = new HomeController();
		assertEquals("home",controller.hello(null));
	}

	@Test
	public void testHomePage() throws Exception{
		HomeController controller = new HomeController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/Index"))
			.andExpect(view().name("Index"));
	}
	
}
