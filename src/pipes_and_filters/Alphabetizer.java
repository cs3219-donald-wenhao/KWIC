package pipes_and_filters;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Alphabetizer {

	public Alphabetizer() {

	}

	/**
	 * Method to tokenize String according to space.
	 * 
	 * @param keyword
	 * @return Queue of String tokens
	 */
	private static ArrayList<String> tokenize(String input) {

		StringTokenizer tokenizer = new StringTokenizer(input);
		ArrayList<String> strTokens = new ArrayList<String>();

		// Tokenizes the search String taken in
		while (tokenizer.hasMoreTokens()) {
			strTokens.add(tokenizer.nextToken());
		}

		return strTokens;
	}

	private static String concatenateTokens(ArrayList<String> tokens) {

		String result = "";

		for (int i = 0; i < tokens.size(); i++) {
			result += " " + tokens.get(i);
		}

		return result.trim();

	}

	public String alphabetize(ArrayList<String> ignoreList, String input) {

		ArrayList<String> tokens = tokenize(input);
			
		for (int i = 0; i < tokens.size(); i++) {
			String currentToken = tokens.get(i);
			if (ignoreList.contains(currentToken.toLowerCase())) {
				tokens.set(i, currentToken.toLowerCase());
			}
		}
		
		String result = concatenateTokens(tokens);
		return result;
	}

}
