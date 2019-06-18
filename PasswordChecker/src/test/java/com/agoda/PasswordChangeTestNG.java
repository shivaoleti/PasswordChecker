package com.agoda;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PasswordChangeTestNG {

	static PasswordChanger passwordChanger;
	private static final Logger LOGGER = Logger.getLogger(PasswordChangeTest.class.getName());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DOMConfigurator.configure("./log/log4j.xml");
		passwordChanger = new PasswordChanger();
	}

	@Test
	public void validpasswordTest() {
		LOGGER.info("-------validPasswordTest Started--------");
		Assert.assertTrue(passwordChanger.changePassword(passwordChanger.getPassword(), "shivaASD12asabcdefgmnoA@1"));
		LOGGER.info("-------validPasswordTest Ended--------");
	}

	@Test
	public void passwordWithLessThan17Characters() {
		Assert.assertTrue(passwordChanger.changePassword(passwordChanger.getPassword(), "shivaoletiklmnoA@1"));
	}

	@Test
	public void passwordWithWrongSystemPassword() {
		Assert.assertFalse(passwordChanger.changePassword("abc@#456", "shivaoletiklmnoA@1"));
	}

	@Test
	public void passwordWithNoDigits() {
		Assert.assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(), "shivashivaoletiklmnoA@"));
	}

	@Test
	public void passwordWithNotAllowdedSpecialChars() {
		Assert.assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(), "shivash1)(ivaoletiklmnoA@"));
	}

	@Test
	public void passwordWithMoreThan50PercenOfDigits() {
		Assert.assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(), "shivaOleti@1234567893456"));
	}

	@Test
	public void passwordWithNoLowerCase() {
		Assert.assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(), "ZXCVBNMLKJHGFDSD@1"));
	}

	@Test
	public void passwordWithNoUpperCase() {
		Assert.assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(), "zxcvbnmlkjhyuoo@1"));
	}

	@Test
	public void passwordWithAllDigits() {
		Assert.assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(), "1234567890987654321"));
	}

	@Test
	public void passwordWithAllSpecialChars() {
		Assert.assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(), "@#$%^&*()!@#_+:]\\*&)"));
	}

	@Test
	public void passwordWithSpecialCharsMoreThan4() {
		Assert.assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(), "AXZSD@#$*@EFGHIJKLMNOAa1"));
	}

	@Test
	public void passwordWithsimilarity() {
		Assert.assertFalse(
				passwordChanger.changePassword(passwordChanger.getPassword(), "shivaOleti@12345Shivaoleti987"));
	}

	@DataProvider(name = "dataProviderTest")
	public static Object[][] credentials() {
		return new Object[][] { { " " }, { "qwerty@A45sssss6*kladaedef" } };
	}

	@Test(dataProvider = "dataProviderTest")
	public void dataProviderTestWithNegativeConditions(String sPassword) throws InterruptedException {
		Assert.assertFalse(
				passwordChanger.changePassword(passwordChanger.getPassword(), sPassword));

	}

	@AfterClass
	public void afterClass() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
