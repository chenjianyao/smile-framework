package com.smileframework.admin.core.controller;

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
