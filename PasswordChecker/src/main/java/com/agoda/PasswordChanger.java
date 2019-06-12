package com.agoda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PasswordChanger {
	private String password;

	public PasswordChanger() {
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
		} else if (!PasswordChangeValidationUtils.isValidPassword(newPassword)) {
			System.err.println("Change Password not satisfies the condition:" + newPassword);
			return false;
		}

		else {
			System.err.println("Change Password  satisfies the condition:" + newPassword);
		}

		return true;
	}

}
