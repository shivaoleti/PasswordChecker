package com.agoda;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    
    public static Boolean ishavingnotAllowdedSpecialChars(String password) {
		Pattern p = Pattern.compile("[^a-z0-9!@]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(password);
		int count = 0;
		while (m.find()) {
			count = count + 1;
		}
		System.out.println("Special Char Count" + count);
		if (count > 1)
			return true;
		return false;
	}

	public static int getUpperCaseCharCount(String password) {
		Pattern p = Pattern.compile("[A-Z]");
		Matcher m = p.matcher(password);
		int count = 0;
		while (m.find()) {
			count = count + 1;
		}
		System.out.println("no of Upper Case Char Count:" + count);
		return count;
	}

	public static int getLowerCaseCharCount(String password) {
		Pattern p = Pattern.compile("[a-z]");
		Matcher m = p.matcher(password);
		int count = 0;
		while (m.find()) {
			count = count + 1;
		}
		System.out.println("no of lower Case Count:" + count);
		return count;
	}

	
}
