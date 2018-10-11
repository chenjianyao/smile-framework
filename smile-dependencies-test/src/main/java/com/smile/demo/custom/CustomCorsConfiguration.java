package com.smile.demo.custom;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * CORS支持 
 * 一、Web开发经常会遇到跨域问题，解决方案有：jsonp，iframe,CORS等等 
 * 
 * CORS与JSONP
 * 
 * 相比 
 * 1、JSONP只能实现GET请求，而CORS支持所有类型的HTTP请求。
 * 2、使用CORS，开发者可以使用普通的XMLHttpRequest发起请求和获得数据，比起JSONP有更好的错误处理。 
 * 3、JSONP主要被老的浏览器支持，它们往往不支持CORS，而绝大多数现代浏览器都已经支持了CORS
 * 
 * @author chenjian
 * @since 2017年1月4日 下午9:11:11
 */
public class CustomCorsConfiguration extends WebMvcConfigurerAdapter {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**").allowedOrigins("http://localhost:8081");
	}
}
