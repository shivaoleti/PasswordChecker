package com.agoda;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PasswordChangeTest {

	static PasswordChanger passwordChanger;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		passwordChanger = new PasswordChanger();
	}

	@Test
	public void validpasswordTest() {
		assertTrue(passwordChanger.changePassword(passwordChanger.getPassword(), "shivaASD12asabcdefgmnoA@1"));
	}

	@Test
	public void passwordWithLessThan17Characters() {
		assertTrue(passwordChanger.changePassword(passwordChanger.getPassword(), "shivaoletiklmnoA@1"));
	}

	@Test
	public void passwordWithWrongSystemPassword() {
		assertFalse(passwordChanger.changePassword("abc@#456", "shivaoletiklmnoA@1"));
	}

	@Test
	public void passwordWithNoDigits() {
		assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(), "shivashivaoletiklmnoA@"));
	}

	@Test
	public void passwordWithNotAllowdedSpecialChars() {
		assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(), "shivash1)(ivaoletiklmnoA@"));
	}

	@Test
	public void passwordWithMoreThan50PercenOfDigits() {
		assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(), "shivaOleti@1234567893456"));
	}

}
