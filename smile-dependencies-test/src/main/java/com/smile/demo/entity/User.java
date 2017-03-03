package com.smile.demo.entity;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class User implements Serializable {
	private static final long serialVersionUID = -4184612532255608530L;
	private Long id;

	@NotBlank
	@Size(max = 5)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
