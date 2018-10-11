package com.smileframework.admin.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenjian
 * @since 2017年3月10日 下午3:24:33
 */
@Controller
public class IndexController {

	@RequestMapping(value = "index")
	public String index() {
		return "index";
	}
}
