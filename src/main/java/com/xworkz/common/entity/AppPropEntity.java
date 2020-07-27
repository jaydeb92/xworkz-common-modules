package com.xworkz.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@Table(name = "app_prop_table")
@NamedQueries({
		@NamedQuery(name = "fetchAllByType", query = "select props from AppPropEntity props where propType=:types"),
		@NamedQuery(name = "fetchAllById", query = "select props from AppPropEntity props where propType=:ids")

})
public class AppPropEntity implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(AppPropEntity.class);
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "PROP_NAME")
	private String propName;
	@Column(name = "PROP_VALUE")
	private String propValue;
	@Column(name = "PROP_TYPE")
	private String propType;

	public AppPropEntity() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());

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
		return "AppPropEntity [id=" + id + ", propName=" + propName + ", propValue=" + propValue + ", propType="
				+ propType + "]";
	}

}