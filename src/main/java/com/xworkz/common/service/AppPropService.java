package com.xworkz.common.service;

import java.util.List;

import com.xworkz.common.dto.AppPropDTO;

public interface AppPropService {

	public List<AppPropDTO> fetchAllByType(String type);

	public List<AppPropDTO> fetchAllById(String id);

}
