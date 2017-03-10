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

import java.io.Serializable;

import org.springframework.ui.ModelMap;

/**
 * 通用DTO
 * 
 * @author chenjian
 * @since 2017年3月10日 下午3:49:05
 */
public class ResponseDto<T> extends ModelMap implements Serializable {
	private static final long serialVersionUID = -3224721079919622572L;

	public final static ResponseDto<Object> SUCCESS = newSuccessResponseDto();
	public final static ResponseDto<Object> FAIL = newFailResponseDto();

	private static ResponseDto<Object> newSuccessResponseDto() {
		ResponseDto<Object> responseDto = new ResponseDto<>();
		responseDto.addAttribute("status", "1").addAttribute("code", "00000000").addAttribute("msg", "操作成功!");
		return responseDto;
	}

	private static ResponseDto<Object> newFailResponseDto() {
		ResponseDto<Object> responseDto = new ResponseDto<>();
		responseDto.addAttribute("status", "0").addAttribute("code", "99999999").addAttribute("msg", "系统异常，请稍后再试!");
		return responseDto;
	}

	public ResponseDto<T> newSuccessResponseDto(T t) {
		ResponseDto<T> responseDto = new ResponseDto<T>();
		responseDto.addAttribute("status", "1").addAttribute("code", "00000000").addAttribute("msg", "操作成功!")
				.addAttribute("data", t);
		return responseDto;
	}

	public ResponseDto<T> newFailResponseDto(String code) {
		return newFailResponseDto("1", code, "操作失败!", null);
	}

	public ResponseDto<T> newFailResponseDto(String code, String msg) {
		return newFailResponseDto("1", code, msg, null);
	}

	public ResponseDto<T> newFailResponseDto(String status, String code, String msg) {
		return newFailResponseDto(status, code, msg, null);
	}

	public ResponseDto<T> newFailResponseDto(String status, String code, String msg, T t) {
		ResponseDto<T> responseDto = new ResponseDto<T>();
		responseDto.addAttribute("status", status).addAttribute("code", code).addAttribute("msg", msg)
				.addAttribute("data", t);
		return responseDto;
	}
}
