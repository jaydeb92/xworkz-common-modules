package com.xworkz.common.dao;

import com.xworkz.common.entity.PersonalInfoEntity;

public interface LoginCountDAO {
	
	public void loginCountUpdate(PersonalInfoEntity entity,int count);
	
	public void disableAccountUpdate(PersonalInfoEntity entity,boolean isLock);

}
