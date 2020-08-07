package com.xworkz.common.service;

import com.xworkz.common.dto.TempleRegistrationDTO;

public interface MailService {

	public void sendMail(TempleRegistrationDTO dto);

	public char[] generatePassword();

	public void sendPasswordByMail(String email);

}
