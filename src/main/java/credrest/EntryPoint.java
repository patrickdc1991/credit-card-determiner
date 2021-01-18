package credrest;

import com.google.gson.Gson;

public class EntryPoint {

	public static void main(String[] args) {
		Gson gson = new Gson();
		CardInformation info = CreditCardDeterminer.determine(args[0]);
		System.out.println(gson.toJson(info));
	}
}
