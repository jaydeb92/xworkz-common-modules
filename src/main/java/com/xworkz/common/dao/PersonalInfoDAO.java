package com.xworkz.common.dao;

import com.xworkz.common.entity.PersonalInfoEntity;

public interface PersonalInfoDAO {

	public void savePersonalInfoEntity(PersonalInfoEntity entity);

	public Long fetchCountByEmail(String email);

	public Long fetchCountByMobileNo(Long mobileNo);

}
