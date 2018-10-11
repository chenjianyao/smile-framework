package com.smile.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smile.admin.service.UserService;
import com.smileframework.admin.core.model.dto.ResponseDto;
import com.smileframework.admin.core.model.dto.ResponseDtoBuilder;
import com.smileframework.admin.core.sequence.SequenceIdGenerateUtils;

/**
 * 
 * @author chenjian
 * @since 2017年3月10日 下午7:56:50
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/{id}")
	@ResponseBody
	public ResponseDto<Object> getUser(@PathVariable String id) {
		return ResponseDtoBuilder.success().setData(userService.selectByPrimaryKey(id)).build();
	}

	@RequestMapping()
	@ResponseBody
	public ResponseDto<Object> getAllUser() {
		Map map = new HashMap();
		map.put("sequence", SequenceIdGenerateUtils.generate("C"));
		return ResponseDtoBuilder.success().setData(map).build();
	}

}
