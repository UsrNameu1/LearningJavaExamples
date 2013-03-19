package com.tracecar.interpreter;

import java.util.ArrayList;

// <command list> ::= <command>* end
public class CommandListNode extends Node {
	private ArrayList<Node> list = new ArrayList<Node>();
	
	@Override
	public void parse(Context context) throws ParseException {
		
		while (true) {
			if (context.currentToken() == null) {
				throw new ParseException("Missing 'end'");
			}
			else if (context.currentToken().equals("end")) {
				context.skipToken("end");
				break;
			}
			else {
				Node commaNode = new CommandNode();
				commaNode.parse(context);
				list.add(commaNode);
			}
		}
	}
	
	@Override
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		for (Node elem : list) {
			buffer.append(elem.toString());
		}
		return buffer.toString();
	}

}
