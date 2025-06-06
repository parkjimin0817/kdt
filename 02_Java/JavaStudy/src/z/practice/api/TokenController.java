package z.practice.api;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		super();
	}
	
	public String afterToken(String str) {
		StringTokenizer tokenizer = new StringTokenizer(str, " ");
		String newStr = "";
		while(tokenizer.hasMoreElements()) {
			newStr += tokenizer.nextToken();
		}
		return newStr;
	}
	
	public String firstCap(String input) {
		String str = "";
//		for(int i=0; i<input.length(); i++) {
//			str += i == 0 ? (input.charAt(i) + "").toUpperCase() : input.charAt(i);
//		}
		
		str = input.substring(0,1).toUpperCase() + input.substring(1);
		return str;
	}
	
	public int findChar(String input, char one) {
		int count = 0;
		for(char c : input.toCharArray()) {
			if(c == one)
				count++;
		}
		return count;
	}
}
