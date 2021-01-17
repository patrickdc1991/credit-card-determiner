package credrest;
import java.util.*;

class CreditCardDeterminer {
	
	public static String determine() {
		return "";
	}
	
	public static boolean luhnValid(String input) {
		int len = input.length();
		String doubledList = "";
		for(int i = 0; i < len; i++) {
			int digit = Character.getNumericValue(input.charAt(len-1-i));
			if (i % 2 == 1) {
				digit *= 2;
			}
			doubledList += Integer.toString(digit);
		}
		int sum = 0;
		for(int i = 0; i < doubledList.length(); i++) {
			sum += Character.getNumericValue(doubledList.charAt(i));
		}
		return sum % 10 == 0;
	}

}
