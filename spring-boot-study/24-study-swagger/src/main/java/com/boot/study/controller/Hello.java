package com.boot.study.controller;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel("你好对象")
@Getter
@Setter
public class Hello implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5681124471306722859L;
	@ApiModelProperty(value = "名称")
	private String name;
	@ApiModelProperty(value = "年龄")
	private Integer age;
}
