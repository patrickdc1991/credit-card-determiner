package credrest;
import credrest.CardInformation;
import java.util.*;

class CreditCardDeterminer {
	
	public static CardInformation determine(String input) {
		CardInformation cardInformation = new CardInformation();
		
		if(!stringIsPositiveNumber(input)) {
			cardInformation.setCardNumber(input);
			cardInformation.setCardType("Unknown");
			cardInformation.setIsLuhnValid("INVALID");
			return cardInformation;
		}
		
		cardInformation.setCardNumber(input);
		if(isAmex(input)) {
			cardInformation.setCardType("Amex");
		} else if(isDiscover(input)) {
			cardInformation.setCardType("Discover");
		} else if(isMastercard(input)) {
			cardInformation.setCardType("Mastercard");
		} else if(isVisa(input)) {
			cardInformation.setCardType("Visa");
		} else {
			cardInformation.setCardType("Unknown");
		}
		
		if(LuhnAlgorithm.validate(input)) {
			cardInformation.setIsLuhnValid("VALID");
		} else {
			cardInformation.setIsLuhnValid("INVALID");
		}
		return cardInformation;
	}
	
	
	public static boolean stringIsPositiveNumber(String input){
		try {
			for(int i = 0; i < input.length(); i++) {
				Integer.parseInt(input.substring(i, i+1));
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static boolean isAmex(String input) {
		if(input.length() == 15) {
			int firstTwo = Integer.parseInt(input.substring(0,1));
			if(firstTwo == 34 || firstTwo == 37) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isDiscover(String input) {
		if(input.length()==16) {
			int firstFour = Integer.parseInt(input.substring(0,3));
			if(firstFour == 6011) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isMastercard(String input) {
		if(input.length()==16) {
			int firstTwo = Integer.parseInt(input.substring(0,1));
			if(firstTwo >= 51 && firstTwo <= 54) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isVisa(String input) {
		if(input.length()==16 || input.length()==13) {
			int firstTwo = Integer.parseInt(input.substring(0,1));
			if(firstTwo >= 51 && firstTwo <= 54) {
				return true;
			}
		}
		return false;
	}

}
