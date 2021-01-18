package credrest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

public class CreditCardDeterminerTest {
		
	@Test
	public void CardTest() {
		assertAll("card tests",
				() -> cardAssert("4111111111111111","VISA","valid"),
				() -> cardAssert("4111111111111","VISA","invalid"),
				() -> cardAssert("4012888888881881","VISA","valid"),
				() -> cardAssert("378282246310005","AMEX","valid"),
				() -> cardAssert("6011111111111117","Discover","valid"),
				() -> cardAssert("5105105105105100","MasterCard","valid"),
				() -> cardAssert("5105 1051 0510 5106","MasterCard","invalid"),
				() -> cardAssert("9111111111111111","Unknown","invalid")
			);
	}

	private void cardAssert(String input, String expectedType, String expectedValidity) {
		Gson gson = new Gson();
		CardInformation expected = new CardInformation(input, expectedType, expectedValidity);
		CardInformation actual = CreditCardDeterminer.determine(input);
		assertEquals(gson.toJson(expected),gson.toJson(actual));		
	}
	
}
