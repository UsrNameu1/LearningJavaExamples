package com.tracecar.interpreter;

import java.util.Arrays;
import java.util.List;

public class Interpreter {
	private Interpreter(){}
	public static List<String> interpretedCommandList(String programCode){
		try {
			Node node = new ProgramNode();
			node.parse(new Context(programCode));
			return Arrays.asList(node.toString().split(" "));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
