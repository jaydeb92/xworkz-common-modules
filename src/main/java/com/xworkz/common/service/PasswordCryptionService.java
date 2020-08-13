package com.xworkz.common.service;

public interface PasswordCryptionService {

	public String encrypt(String strToEncrypt);

	public String decrypt(String strToDecrypt);

}
