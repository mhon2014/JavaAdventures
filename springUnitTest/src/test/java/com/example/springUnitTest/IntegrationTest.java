package com.example.springUnitTest;

import com.example.springUnitTest.repository.ProductRepository;
import com.example.springUnitTest.service.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getProductTest() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/product/{name}", "beer"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.name").value("beer"))
				.andExpect(jsonPath("$.price").value("10.0"));
	}

}
