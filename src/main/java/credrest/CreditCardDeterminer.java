package credrest;
import java.util.*;

class CreditCardDeterminer {
	
	public static String determine() {
		return "";
	}
	
	private static boolean luhnValid(String input) {
		String doubledList = "";
		for(int i = 0; i < input.length(); i++) {
			int digit = Character.getNumericValue(input.charAt(input.length() - i));
			if (i % 2 == 1) {
				digit *= 2;
			}
			doubledList += Integer.toString(digit);
		}
		int sum = 0;
		for(int i = 0; i < doubledList.length(); i++) {
			sum += Character.getNumericValue(input.charAt(i));
		}
		return sum % 10 == 0;
	}

}
