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
package com.smile.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenjian
 * @since 2017年3月10日 下午3:24:33
 */
@Controller
@RequestMapping(value = "page")
public class PageController {

	@RequestMapping("/{pageNo}")
	public String page(@PathVariable String pageNo) {
		return pageNo;
	}
}
