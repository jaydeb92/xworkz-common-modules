package com.xworkz.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@Table(name = "temple_reg_visiting_info_table")
public class VisitingInfoEntity implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(VisitingInfoEntity.class);
	@Id
	@Column(name = "V_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "SPECIAL_ENTRANCE")
	private String specialEntrance;
	@Column(name = "DATE")
	private Date date;
	@Column(name = "NO_OF_PEOPLE")
	private Integer noOfPeople;
	@Column(name = "PRASADA")
	private String prasada;
	@Column(name = "ID_CARD")
	private String idCard;
	@Column(name = "ID_NUMBER")
	private Long idNumber;
	@Column(name = "POOJA_TYPE")
	private String poojaType;
	
	@OneToOne
	@JoinColumn(name = "ID")
	private PersonalInfoEntity personalInfoEntity;

	public VisitingInfoEntity() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public PersonalInfoEntity getPersonalInfoEntity() {
		return personalInfoEntity;
	}

	public void setPersonalInfoEntity(PersonalInfoEntity personalInfoEntity) {
		this.personalInfoEntity = personalInfoEntity;
	}

	@Override
	public String toString() {
		return "VisitingInfoEntity [id=" + id + ", specialEntrance=" + specialEntrance + ", date=" + date
				+ ", noOfPeople=" + noOfPeople + ", prasada=" + prasada + ", idCard=" + idCard + ", idNumber="
				+ idNumber + ", poojaType=" + poojaType + "]";
	}

	
}
