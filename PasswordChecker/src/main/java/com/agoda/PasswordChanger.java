package com.agoda;

import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChanger {

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
			System.out.println(charArray.get(ch));
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

	private static Boolean hasUpperCaseCharacter(String password) {
		char[] passwordArray = password.toCharArray();
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (Character.isUpperCase(ch))
				return true;

		}

		return false;
	}

	private static Boolean hasLowerCaseCharacter(String password) {
		char[] passwordArray = password.toCharArray();
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (Character.isLowerCase(ch))
				return true;

		}

		return false;
	}

	private static Boolean hasDigits(String password) {
		char[] passwordArray = password.toCharArray();
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (Character.isDigit(ch))
				return true;

		}

		return false;
	}

	private static Boolean hasAllowdedSpecialChars(String password) {
		char[] passwordArray = password.toCharArray();
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (ch == '!' || ch == '@' || ch == '&' || ch == '#' || ch == '$' || ch == '*')
				return true;

		}

		return false;
	}

	private static Boolean hasUpperLowerDigitSPecialChar(String password) {

		if (hasUpperCaseCharacter(password) && hasLowerCaseCharacter(password) && hasDigits(password)
				&& hasAllowdedSpecialChars(password))
			return true;
		else
			return false;

	}

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

	public static Boolean hasPasswordMoreThan50PercentDigits(String password) {
		System.out.println("*********************");
		System.out.println(getDigitsCount(password));
		System.out.println(password.length());
		System.out.println(4 / 15.0);
		Float value = (getDigitsCount(password) / (float) password.length());
		System.out.println("Value:" + value);

		System.out.println("*********************");
		if ((float) (getDigitsCount(password) / password.length()) * 100 > 50)
			return true;
		return false;
	}

	public static void main(String args[]) {
		System.out.println("is Repeated Char more than 4: " + hasRepeatedCharMoreThanFour("shivashivashivashivaa"));
		System.out.println("Special Char Count:" + hasAllowdedSpecialCharMoreThanFour("shiva#$%@!!"));
		System.err.println("hasUpperLowerDigitSPecialChar:" + hasUpperLowerDigitSPecialChar("shiva#$%@!!"));

		System.out
				.println("hasPasswordMoreThan50PercentDigits:" + hasPasswordMoreThan50PercentDigits("SHivaoleti1234!"));

	}

}
