package com.xworkz.common.service;

import com.xworkz.common.entity.PersonalInfoEntity;

public interface LoginCountService {

	public String loginCount(PersonalInfoEntity personalInfoEntity,int count);
	
	public String disableLogin(PersonalInfoEntity personalInfoEntity,boolean isLock);

}
