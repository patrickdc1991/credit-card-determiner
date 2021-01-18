package credrest;

public class LuhnAlgorithm {
	
	public static boolean validate(String input) {
		int[] numArray = stringToNumArray(input);
		int secondToLastIndex = numArray.length - 2;
		for(int i = secondToLastIndex; i >= 0; i-=2) {
			numArray[i]*=2;
		}
		String doubledNumbers = numArrayToString(numArray);
		int[] doubledNumberArray = stringToNumArray(doubledNumbers);
		int sum = 0;
		for(int num: doubledNumberArray) {
			sum+=num;
		}
		return sum % 10 == 0;
	}
	
	private static int[] stringToNumArray(String input){
		int length = input.length();
		int[] ret = new int[length];
		for(int i = 0; i < length; i++) {
			ret[i] = Character.getNumericValue(input.charAt(i));
		}
		return ret;
	}
	
	private static String numArrayToString(int[] input){
		StringBuffer ret = new StringBuffer();
		for(int num: input) {
			ret.append(num);
		}
		return ret.toString();
	}


}
