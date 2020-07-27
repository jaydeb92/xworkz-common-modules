package com.xworkz.common.dao;

import java.util.List;

import com.xworkz.common.entity.AppPropEntity;

public interface AppPropDAO {

	public List<AppPropEntity> fetchAllByType(String type);

	public List<AppPropEntity> fetchAllById(String id);

}
