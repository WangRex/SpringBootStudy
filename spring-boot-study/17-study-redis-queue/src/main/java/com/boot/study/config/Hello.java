package com.boot.study.config;

import java.io.Serializable;

import lombok.Data;

@Data
public class Hello implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5681124471306722859L;
	private String name;
	private Integer age;
}
