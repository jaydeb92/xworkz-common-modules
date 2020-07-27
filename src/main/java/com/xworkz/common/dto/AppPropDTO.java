package com.xworkz.common.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class AppPropDTO implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(AppPropDTO.class);
	private Integer id;
	private String propName;
	private String propValue;
	private String propType;

	public AppPropDTO() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	public AppPropDTO(Integer id, String propName, String propValue, String propType) {
		LOGGER.info("invoked parameterized contructor in AppPropDTO class");
		this.id = id;
		this.propName = propName;
		this.propValue = propValue;
		this.propType = propType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropValue() {
		return propValue;
	}

	public void setPropValue(String propValue) {
		this.propValue = propValue;
	}

	public String getPropType() {
		return propType;
	}

	public void setPropType(String propType) {
		this.propType = propType;
	}

	@Override
	public String toString() {
		return "AppPropDTO [id=" + id + ", propName=" + propName + ", propValue=" + propValue + ", propType=" + propType
				+ "]";
	}

}