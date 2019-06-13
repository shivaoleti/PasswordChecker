package com.agoda;

import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class PasswordChangeValidationUtils {
	
	
	public static Boolean  isValidPassword(String password) {

		if (hasPasswordGreatherThan17(password) && hasUpperLowerDigitSPecialChar(password)
				&& !hasRepeatedCharMoreThanFour(password) && !hasAllowdedSpecialCharMoreThanFour(password)
				&& !hasPasswordMoreThan50PercentDigits(password) &&!hasHavingnotAllowdedSpecialChars(password))
			return true;
		else
			return false;

	}

	/*
	 * The Following Method returns true if any character repeated more than 4 times
	 * Using HashMap to get the count of repeated character
	 */

	private static Boolean hasRepeatedCharMoreThanFour(String password) {
		char[] passwordLetters = password.toCharArray();
		HashMap<Character, Integer> charArray = new HashMap<>();

		for (char ch : passwordLetters) {
			if (charArray.containsKey(ch))
				charArray.put(ch, charArray.get(ch) + 1);
			else
				charArray.put(ch, 1);
		}

		Set<Character> keys = charArray.keySet();
		for (char ch : keys) {
			//System.out.println(charArray.get(ch));
			if (charArray.get(ch) > 4)
				return true;
		}

		return false;
	}

	/*
	 * The Following Method returns true if password length is greather than 17
	 */

	private static Boolean hasPasswordGreatherThan17(String password) {
		if (password.length() > 17)
			return true;
		else
			return false;
	}
	
	/*
	 * return true - password has UpperCase
	 * return false - password has no UpperCase
	 */

	private static Boolean hasUpperCaseCharacter(String password) {
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (Character.isUpperCase(ch))
				return true;

		}

		return false;
	}
	
	/*
	 * return true - password has LowerCase
	 * return false - password has no LowerCase
	 */

	private static Boolean hasLowerCaseCharacter(String password) {
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (Character.isLowerCase(ch))
				return true;

		}

		return false;
	}
	
	/*
	 * return true - password has digits
	 * return false - password has no digits
	 */

	private static Boolean hasDigits(String password) {
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (Character.isDigit(ch))
				return true;

		}

		return false;
	}

	/*
	 * return true - password has allowed special chars
	 * return false - password has no allowed special chars
	 */
	
	private static Boolean hasAnyOfAllowdedSpecialChars(String password) {
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (ch == '!' || ch == '@' || ch == '&' || ch == '#' || ch == '$' || ch == '*')
				return true;

		}

		return false;
	}
	
	public static Boolean hasHavingnotAllowdedSpecialChars(String password) {
		Pattern p = Pattern.compile("[^a-z0-9!@&#$*]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(password);
		int count = 0;
		while (m.find()) {
			count = count + 1;
		}
		System.out.println("Special not allowded Char Count" + count);
		if (count > 1)
			return true;
		return false;
	}
	
	/*
	 * return true - password has upper,lower,special and digit characters
	 * return false - password has any of upper,lower,special and digit characters doesn't have
	 */
	
	private static Boolean hasUpperLowerDigitSPecialChar(String password) {

		if (hasUpperCaseCharacter(password) && hasLowerCaseCharacter(password) && hasDigits(password)
				&& hasAnyOfAllowdedSpecialChars(password))
			return true;
		else
			return false;

	}
	
	/*
	 * return true - password has allowed special characters more than 4
	 * return false - password has allowed special characters less than or equal to 4
	 */

	public static Boolean hasAllowdedSpecialCharMoreThanFour(String password) {
		Pattern p = Pattern.compile("[!@#$&*]");
		Matcher m = p.matcher(password);
		int count = 0;
		while (m.find()) {
			count = count + 1;
		}
		System.err.println("Alloded Special Char Count=" + count);
		if (count > 4)
			return true;

		return false;
	}
	
	/*
	 * return no of digits in password
	 */

	public static int getDigitsCount(String password) {
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(password);
		int count = 0;
		while (m.find()) {
			count = count + 1;
		}
		System.out.println("no of Digit Count:" + count);
		return count;
	}
	
	/*
	 * return true -- if password has more than 50% of digits in length
	 * return false - if password has less than or equal 50% of digits in length
	 */

	public static Boolean hasPasswordMoreThan50PercentDigits(String password) {
		System.out.println("*********************");
		Float value = (float)(getDigitsCount(password) / (float) password.length());
		System.out.println("Value:" + value);

		System.out.println("*********************");
		if ((float) (getDigitsCount(password) /(float) password.length()) * 100 > 50)
			return true;
		return false;
	}
	
	
	

}
