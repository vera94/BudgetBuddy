package utils;

import java.util.regex.Pattern;

public class ValidationUtil {
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static boolean notNullOrEmpty(String value) {
		return value != null && !value.isEmpty();
	}
	
	public static boolean hasValidLength(String string, int minLength, int maxValue) {
		
		return notNullOrEmpty(string) && string.length() >= minLength && string.length() <= maxValue;
	}
	
	public static boolean validate(String string, int minLength, int maxLength, Pattern pattern) {
		return hasValidLength(string, minLength, maxLength) && pattern.matcher(string).find();
	}	
	
}
