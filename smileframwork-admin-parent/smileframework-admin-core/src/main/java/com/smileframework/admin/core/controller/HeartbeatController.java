package com.smileframework.admin.core.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;
import com.smileframework.admin.core.model.dto.ResponseDto;
import com.smileframework.admin.core.model.dto.ResponseDtoBuilder;

/**
 * 心跳服务 检测web服务是否正常的接口
 * 
 * @author chenjian
 * @since 2017年3月10日 下午3:41:51
 */
@RestController
@RequestMapping("server")
public class HeartbeatController {

	@RequestMapping(value = "/checkServer", method = RequestMethod.GET)
	public ResponseDto<Object> checkServer() {
		return ResponseDto.SUCCESS;
	}

	@RequestMapping(value = "/getServerData", method = RequestMethod.GET)
	public ResponseDto<Object> getServerData() {
		Map<String, Object> map = Maps.newHashMap();
		map.put("time", new Date());
		map.put("version", "1.0.0");
		return ResponseDtoBuilder.success().setData(map).build();
	}
}
