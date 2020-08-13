package com.xworkz.common.dao;

import com.xworkz.common.entity.PersonalInfoEntity;

public interface LoginDAO {

	public Long checkMailExistingForgeneratePassword(String email);

	public PersonalInfoEntity fetchEntityByEmail(String email);

}
