package com.agoda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class PasswordChanger {
	private static final Logger logger = Logger.getLogger(PasswordChanger.class.getName());
	private String password;

	public PasswordChanger() {
		logger.info("------------Properties File Loaded To Read System Mock Password-----------");
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(new File(System.getProperty("user.dir") + "\\Authentication.properties")));
			password = properties.getProperty("password");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String getPassword() {
		return this.password;
	}

	public Boolean changePassword(String oldPassword, String newPassword) {

		if (!oldPassword.equals(getPassword())) {
			System.out.println("Wrong oldPassword");
			return false;
		} else if (PasswordChangeValidationUtils.isValidPassword(newPassword)) {
			System.err.println("Change Password not satisfies the condition:" + newPassword);
			return true;
		}
		else if(PasswordChangeValidationUtils.passwordSimilarity(newPassword)>=80)
			return true;

		else {
			System.err.println("Change Password  satisfies the condition:" + newPassword);
		}

		return false;
	}
	
	/*
	 * float getPasswordSimilarity(String newPassword) { int
	 * noOfchars=StringUtils.getLevenshteinDistance(newPassword,getPassword() );
	 * logger.info("new Password:"+newPassword);
	 * logger.info("system Password:"+getPassword());
	 * logger.info("no of chars not matched:"+noOfchars); float
	 * similarity=(float)(getPassword().length()-noOfchars)/getPassword().length();
	 * logger.info("Password Similarity:"+similarity); return (similarity)*100; }
	 */

}
