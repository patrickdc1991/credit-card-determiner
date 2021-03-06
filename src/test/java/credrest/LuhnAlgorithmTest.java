package credrest;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class LuhnAlgorithmTest {
	
	static String[] validNums = {
			"4444333322221111",
			"5105105105105100",
			"2223000048400011",
			"2223520043560014",
			"378282246310005",
			"38520000023237",
			"30569309025904"
	};
	
	static String[] invalidNums = {
			"4444633322221111",
			"5105145105105100",
			"2223000348400011",
			"2223520042560014",
			"378282241110005",
			"385200000232362",
			"30569309045904"
	};


	@Test
	public void luhnValidTest() {
		
		List<String> validNumFails = new ArrayList<String>();
		for(String validNum : validNums) {
			if(!LuhnAlgorithm.validate(validNum)) {
				validNumFails.add(validNum);
			}
		}
		List<String> invalidNumFails = new ArrayList<String>();
		for(String invalidNum : invalidNums) {
			if(LuhnAlgorithm.validate(invalidNum)) {
				invalidNumFails.add(invalidNum);
			}
		}
		if(!validNumFails.isEmpty() || !invalidNumFails.isEmpty()) {
			StringBuffer msg = new StringBuffer();
			msg.append("The following values were returned as invalid " +
					"when they should have been valid:\n");
			for(String validNumFail : validNumFails) {
				msg.append(validNumFail + "\n");
			}
			msg.append("And the following values were returned as valid when " +
					"they should have been invalid:\n");
			for(String invalidNumFail : invalidNumFails) {
				msg.append(invalidNumFail + "\n");
			}
			fail(msg.toString());
		}
	}
}
