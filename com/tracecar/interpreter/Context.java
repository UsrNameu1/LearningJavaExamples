package com.tracecar.interpreter;

import java.util.StringTokenizer;

public class Context {
	private StringTokenizer tokenizer;
	private String currentToken;
	public Context(String text){
		tokenizer = new StringTokenizer(text);
		nextToken();
	}
	
	public String nextToken(){
		currentToken = tokenizer.hasMoreTokens()? tokenizer.nextToken() : null;
		return currentToken;
	}
	
	public String currentToken(){
		return currentToken;
	}
	
	public void skipToken(String token) throws ParseException{
		if (!token.equals(currentToken)) {
			throw new ParseException("Warning: " + token + " is expected, but " + currentToken + " is found.");
		}
		nextToken();
	}
	
	public int currentNumber() throws ParseException {
		int number = 0;
		try {
			number = Integer.parseInt(currentToken);
		} catch (NumberFormatException e) {
			throw new ParseException("Warning: " + e);
		}
		return number;
	}
}
