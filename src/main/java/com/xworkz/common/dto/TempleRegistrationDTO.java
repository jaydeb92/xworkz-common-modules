package com.xworkz.common.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

public class TempleRegistrationDTO implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(TempleRegistrationDTO.class);

	private String name;
	private Long mobileNo;
	private String address;
	private Integer age;
	private String state;
	private String email;
	private String specialEntrance;
	private Date date;
	private Integer noOfPeople;
	private String prasada;
	private String idCard;
	private Long idNumber;
	private String poojaType;
	private String password;

	public TempleRegistrationDTO() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSpecialEntrance() {
		return specialEntrance;
	}

	public void setSpecialEntrance(String specialEntrance) {
		this.specialEntrance = specialEntrance;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(Integer noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public String getPrasada() {
		return prasada;
	}

	public void setPrasada(String prasada) {
		this.prasada = prasada;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}

	public String getPoojaType() {
		return poojaType;
	}

	public void setPoojaType(String poojaType) {
		this.poojaType = poojaType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "TempleRegistrationDTO [name=" + name + ", mobileNo=" + mobileNo + ", address=" + address + ", age="
				+ age + ", state=" + state + ", email=" + email + ", specialEntrance=" + specialEntrance + ", date="
				+ date + ", noOfPeople=" + noOfPeople + ", prasada=" + prasada + ", idCard=" + idCard + ", idNumber="
				+ idNumber + ", poojaType=" + poojaType + "]";
	}

}
