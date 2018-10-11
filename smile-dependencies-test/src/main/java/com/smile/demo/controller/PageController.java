package com.smile.demo.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smileframework.quartz.dynamic.QuartzManager;

/**
 * 
 * @author chenjian
 * @since 2017年3月3日 上午10:10:17
 */
@Controller
@RequestMapping("/page")
public class PageController {
	private final static Logger logger = LoggerFactory.getLogger(PageController.class);

	@Resource
	private QuartzManager quartzManager;
	
	@RequestMapping("/{pageNo}")
	public String page(@PathVariable String pageNo) {
		logger.info("跳转页面{}", pageNo);
		
		
		
		return pageNo;
	}
}
