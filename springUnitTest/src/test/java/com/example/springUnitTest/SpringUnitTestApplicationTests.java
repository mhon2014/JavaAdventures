package com.example.springUnitTest;

import com.example.springUnitTest.repository.ProductRepository;
import com.example.springUnitTest.service.ProductService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class SpringUnitTestApplicationTests {

	@MockBean
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@BeforeAll
	public static void beforeClass(){
		System.out.println("Before Class");
	}

	@BeforeEach
	public void before(){
		System.out.println("Before");
	}

	@Test
	public void noProductsReturnedTest(){
		given(productRepository.getProduct()).willReturn(Collections.emptyList());
		List<String> res = productService.getProductNamesEvenChar();
		assertTrue(res.isEmpty());
	}

	@Test
	public void moreProductsAreFoundTest(){
		List<String> input = Arrays.asList("aa", "bbbb", "ccc");
		given(productRepository.getProduct()).willReturn(input);
		List<String> res = productService.getProductNamesEvenChar();
		assertEquals(2,res.size());
		verify(productRepository, times(1)).getProduct();
	}
}
