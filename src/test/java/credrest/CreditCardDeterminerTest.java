package credrest;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class CreditCardDeterminerTest {
	
	@Test
	public void invalidNumberTest() {
		String[] validNums = {
				"1",
				"112",
				"1234567890987654321234567890987654321",
				"0"
		};
		String[] invalidNums = {
				"123456a",
				"-123456",
				"abcdef",
				"abc def",
				"123 456"
		};
		List<String> falsePositives = new ArrayList<String>();
		for(String cardNum : invalidNums) {
			if(CreditCardDeterminer.stringIsPositiveNumber(cardNum)) {
				falsePositives.add(cardNum);
			}
		}
		
		List<String> falseNegatives = new ArrayList<String>();
		for(String cardNum : validNums) {
			if(!CreditCardDeterminer.stringIsPositiveNumber(cardNum)) {
				falseNegatives.add(cardNum);
			}
		}
		
		if(!falsePositives.isEmpty() || !falseNegatives.isEmpty()) {
			StringBuffer msg = new StringBuffer();
			msg.append("The following invalid strings were not " +
					"marked as invalid:\n");
			for(String cardNum: falsePositives) {
				msg.append(cardNum + "\n");
			}
			msg.append("The following valid strings were " +
					"marked as invalid:\n");
			for(String cardNum: falseNegatives) {
				msg.append(cardNum + "\n");
			}
			fail(msg.toString());
		}
	}
	
	
}
