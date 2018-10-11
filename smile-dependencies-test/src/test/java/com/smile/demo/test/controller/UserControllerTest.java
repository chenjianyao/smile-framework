package com.smile.demo.test.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * API单元测试
 * 
 * @author chenjian
 * @since 2017年1月5日 下午1:37:47
 */
public class UserControllerTest extends AbstractControllerTest {
	private static final String VIEW_API_URL = "/user/123456";

	/**
	 * 方式一：可用
	 *
	 * @author chenjian
	 * @since 2017年1月5日 下午2:17:20
	 * @throws Exception
	 * @see
	 */
	@Test
	public void test() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("name", "smile");
		MvcResult mvcResult1 = this.mockMVCPost(VIEW_API_URL, params);
		System.out.println(mvcResult1.getResponse().getContentAsString());
		
		params.clear();
		MvcResult mvcResult2 = this.mockMVCPost(VIEW_API_URL, params);
		System.out.println(mvcResult2.getResponse().getContentAsString());
	}

	/**
	 * 方式二：目前不可用
	 *
	 * @author chenjian
	 * @since 2017年1月5日 下午2:17:02
	 * @see
	 */
	//@Test
	@Deprecated
	public void test2() {
		String url = "http://127.0.0.1:8081" + VIEW_API_URL;
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("name", "Tom");
		String result = this.restTemplate.postForObject(url, map, String.class);
		System.out.println(result);
		// assertThat(result, Matchers.containsString("Tom"));
	}

}
