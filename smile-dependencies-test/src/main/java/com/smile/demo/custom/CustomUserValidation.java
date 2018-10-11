package com.smile.demo.custom;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 
 * @author chenjian
 * @since 2017年1月5日 下午4:17:16
 */
@Component
public class CustomUserValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {

	}
}
