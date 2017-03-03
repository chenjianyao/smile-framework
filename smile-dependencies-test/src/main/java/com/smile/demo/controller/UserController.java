package com.smile.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.smile.demo.entity.User;
import com.smile.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/{id}")
	private User view(User User) {
		User user = new User();
		user.setId(new Double(Math.random() * 1000).longValue());
		user.setName("zhang" + new Double(Math.random() * 1000).longValue());
		return userService.getUser(user);
	}

	// 细粒度支持跨域
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping("/cors/{id}")
	private User corsview(@Valid User User) {
		User user = new User();
		user.setId(new Double(Math.random() * 1000).longValue());
		user.setName("zhang" + new Double(Math.random() * 1000).longValue());
		return userService.getUser(user);
	}

	@RequestMapping("/test/{name}")
	public String testsave(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "error";
		}
		return "success";
	}

	@RequestMapping("/test/date")
	public ModelMap testsave() {
		ModelMap modelMap = new ModelMap();
		List list = Lists.newArrayList("smile","smile",new Date());
		Map map = Maps.newLinkedHashMap();
		map.put("time", new Date());
		map.put("two", 1111.5f);
		modelMap.addAllAttributes(list).addAllAttributes(map);
		
		return modelMap;
	}
}
