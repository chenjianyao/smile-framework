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
package com.smileframework.admin.core.model.dto;

/**
 * 通用DTO构建器
 * 
 * @author chenjian
 * @since 2017年3月10日 下午3:49:05
 */
public class ResponseDtoBuilder {
	private ResponseDto<Object> responseDto = new ResponseDto<Object>();

	public static ResponseDtoBuilder newResponseDto() {
		ResponseDtoBuilder responseDtoBuilder = new ResponseDtoBuilder();
		return responseDtoBuilder;
	}

	/**
	 * 构建成功响应dto
	 *
	 * @author chenjian
	 * @since 2017年3月10日 下午9:07:16
	 * @return
	 * @see
	 */
	public static ResponseDtoBuilder success() {
		ResponseDtoBuilder responseDtoBuilder = new ResponseDtoBuilder();
		responseDtoBuilder.responseDto.addAttribute("status", "1").addAttribute("code", "00000000").addAttribute("msg",
				"操作成功!");
		return responseDtoBuilder;
	}

	/**
	 * 构建失败响应dto
	 *
	 * @author chenjian
	 * @since 2017年3月10日 下午9:07:40
	 * @return
	 * @see
	 */
	public static ResponseDtoBuilder fail() {
		ResponseDtoBuilder responseDtoBuilder = new ResponseDtoBuilder();
		responseDtoBuilder.responseDto.addAttribute("status", "0").addAttribute("code", "99999999").addAttribute("msg",
				"系统异常，请稍后再试!");
		return responseDtoBuilder;
	}

	public ResponseDtoBuilder setStatus(String status) {
		responseDto.addAttribute("status", status);
		return this;
	}

	public ResponseDtoBuilder setCode(String code) {
		responseDto.addAttribute("code", code);
		return this;
	}

	public ResponseDtoBuilder setMsg(String msg) {
		responseDto.addAttribute("msg", msg);
		return this;
	}

	public ResponseDtoBuilder setData(Object data) {
		responseDto.addAttribute("data", data);
		return this;
	}

	public ResponseDto<Object> build() {
		return responseDto;
	}
}
