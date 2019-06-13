package com.agoda;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;

public class PasswordChangeTest {

	static PasswordChanger passwordChanger;
	private static final Logger LOGGER = Logger.getLogger(PasswordChangeTest.class.getName());
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DOMConfigurator.configure("./log/log4j.xml");
		passwordChanger = new PasswordChanger();
	}

	
	  @Test public void validpasswordTest() {
	  LOGGER.info("-------validPasswordTest Started--------");
	  assertTrue(passwordChanger.changePassword(passwordChanger.getPassword(),
	  "shivaASD12asabcdefgmnoA@1"));
	  LOGGER.info("-------validPasswordTest Ended--------"); }
	  
	  @Test public void passwordWithLessThan17Characters() {
	  assertTrue(passwordChanger.changePassword(passwordChanger.getPassword(),
	  "shivaoletiklmnoA@1")); }
	  
	  @Test public void passwordWithWrongSystemPassword() {
	  assertFalse(passwordChanger.changePassword("abc@#456",
	  "shivaoletiklmnoA@1")); }
	  
	  @Test public void passwordWithNoDigits() {
	  assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(),
	  "shivashivaoletiklmnoA@")); }
	  
	  @Test public void passwordWithNotAllowdedSpecialChars() {
	  assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(),
	  "shivash1)(ivaoletiklmnoA@")); }
	  
	  @Test public void passwordWithMoreThan50PercenOfDigits() {
	  assertFalse(passwordChanger.changePassword(passwordChanger.getPassword(),
	  "shivaOleti@1234567893456")); }
	 
	@Test
	public void passwordSimilarity()
	{
		LOGGER.info("Password Similarity:"+passwordChanger.getPasswordSimilarity("shivaOli@891234Shiva"));
		
	}

}
