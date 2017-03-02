/*
 * Copyright by mobanker and the original author or authors.
 * 
 * This document only allow internal use ,Any of your behaviors using the file
 * not internal will pay legal responsibility.
 *
 * You may learn more information about mobanker from
 *
 *      http://www.mobanker.com/
 *
 */
package com.smile.demo.test.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

/**
 * 基本测试类
 * 
 * @author chenjian
 * @since 2017年1月5日 上午10:53:24
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//@ContextConfiguration({ "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml", "classpath*: spring/**.xml" })
@ContextConfiguration({ "classpath:spring-application.xml", "classpath:spring-mvc.xml" })
public class AbstractControllerTest {
	@Autowired
	protected WebApplicationContext wac;
	protected MockMvc mockMvc;
	protected RestTemplate restTemplate;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		// this.restTemplate = new TestRestTemplate();
		this.restTemplate = new RestTemplate();
	}

	public MvcResult mockMVCPostJson(String apiUrl, String jsonString) throws Exception {
		return this.mockMvc.perform(MockMvcRequestBuilders.post(apiUrl).content(jsonString))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				// .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("0"))
				// .andExpect(MockMvcResultMatchers.jsonPath("$.error").exists())
				.andReturn();

		// 测试跳转页面
		// andExpect(MockMvcResultMatchers.view().name("/index")).andReturn();
	}

	public MvcResult mockMVCPost(String apiUrl, MultiValueMap<String, String> params) throws Exception {
		return this.mockMvc.perform(MockMvcRequestBuilders.post(apiUrl).params(params))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				// .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("0"))
				// .andExpect(MockMvcResultMatchers.jsonPath("$.error").exists())
				.andReturn();
	}
}
