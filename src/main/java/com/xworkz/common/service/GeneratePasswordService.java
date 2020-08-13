package com.xworkz.common.service;

public interface GeneratePasswordService {

	public String generatePassword();

	public String sendGeneratedPassword(String email);

	public String reSendGeneratedPassword(String email);

}
