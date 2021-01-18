package credrest;

public class CardInformation {
	private String cardNumber;
	private String cardType;
	private String isLuhnValid;
	public CardInformation(String cardNumber, String cardType, String isLuhnValid) {
		super();
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.isLuhnValid = isLuhnValid;
	}
	public CardInformation() {
		super();
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getIsLuhnValid() {
		return isLuhnValid;
	}
	public void setIsLuhnValid(String isLuhnValid) {
		this.isLuhnValid = isLuhnValid;
	}
}
