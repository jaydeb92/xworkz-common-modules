package com.xworkz.common.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;

@Entity
@Table(name = "temple_reg_personal_info_table")
@NamedQueries({
		@NamedQuery(name = "fetchCountByEmail", query = "select count(*) from PersonalInfoEntity per where per.email=:Email"),
		@NamedQuery(name = "fetchCountByMobileNo", query = "select count(*) from PersonalInfoEntity per where per.mobileNo=:MobileNO "),

		@NamedQuery(name = "fetchPersonalInfoEntityByEmail", query = "from PersonalInfoEntity per left join fetch per.visitingInfoEntity where per.email=:Email"),
		@NamedQuery(name = "checkMailExistingForgeneratePassword", query = "select count(*) from PersonalInfoEntity per where per.email=:Email"),
		@NamedQuery(name = "fetchEntityByEmail", query = "from PersonalInfoEntity per where per.email=:Email") })
public class PersonalInfoEntity implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(PersonalInfoEntity.class);
	@Id
	@Column(name = "P_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "MOBILE_NO")
	private Long mobileNo;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "AGE")
	private Integer age;
	@Column(name = "STATE")
	private String state;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "LOGIN_COUNT")
	private Integer loginCount;
	@Column(name = "IS_LOCK")
	private Boolean isLock;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "personalInfoEntity")
	private VisitingInfoEntity visitingInfoEntity;

	public PersonalInfoEntity() {
		LOGGER.info("created\t" + this.getClass().getSimpleName());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public VisitingInfoEntity getVisitingInfoEntity() {
		return visitingInfoEntity;
	}

	public void setVisitingInfoEntity(VisitingInfoEntity visitingInfoEntity) {
		this.visitingInfoEntity = visitingInfoEntity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Boolean getIsLock() {
		return isLock;
	}

	public void setIsLock(Boolean isLock) {
		this.isLock = isLock;
	}

	@Override
	public String toString() {
		return "PersonalInfoEntity [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + ", address=" + address
				+ ", age=" + age + ", state=" + state + ", email=" + email + "]";
	}

}
