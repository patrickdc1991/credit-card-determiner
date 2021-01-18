package credrest;

class CreditCardDeterminer {
	
	public static CardInformation determine(String input) {
		CardInformation cardInformation = new CardInformation();
		cardInformation.setCardNumber(input);
		String cardNumber = input.replaceAll("\\s+", "");
		if(!stringIsPositiveNumber(cardNumber)) {
			cardInformation.setCardType("Not a number");
			cardInformation.setIsLuhnValid("Not a number");
			return cardInformation;
		}
		
		if(isAmex(cardNumber)) {
			cardInformation.setCardType("AMEX");
		} else if(isDiscover(cardNumber)) {
			cardInformation.setCardType("Discover");
		} else if(isMastercard(cardNumber)) {
			cardInformation.setCardType("MasterCard");
		} else if(isVisa(cardNumber)) {
			cardInformation.setCardType("VISA");
		} else {
			cardInformation.setCardType("Unknown");
		}
		
		if(LuhnAlgorithm.validate(cardNumber)) {
			cardInformation.setIsLuhnValid("valid");
		} else {
			cardInformation.setIsLuhnValid("invalid");
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
			int firstTwo = Integer.parseInt(input.substring(0,2));
			if(firstTwo == 34 || firstTwo == 37) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isDiscover(String input) {
		if(input.length()==16) {
			int firstFour = Integer.parseInt(input.substring(0,4));
			if(firstFour == 6011) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isMastercard(String input) {
		if(input.length()==16) {
			int firstTwo = Integer.parseInt(input.substring(0,2));
			if(firstTwo >= 51 && firstTwo <= 54) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isVisa(String input) {
		if(input.length()==16 || input.length()==13) {
			int first = Integer.parseInt(input.substring(0,1));
			if(first == 4) {
				return true;
			}
		}
		return false;
	}

}
